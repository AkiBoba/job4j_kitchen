package ru.job4j.job4j_kitchen.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.job4j.job4j_kitchen.api.APIService;
import ru.job4j.job4j_kitchen.model.OrderDTO;
import ru.job4j.job4j_kitchen.model.Status;

@Service
@Slf4j
@RequiredArgsConstructor
public class KitchenService {
    private final OrderService orderService;
    private final APIService apiService;
    private final DishService dishService;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @KafkaListener(topics = "cooked_order")
    public void receiveOrder(String newOrder) throws JsonProcessingException {
        OrderDTO order = OBJECT_MAPPER.readValue(newOrder, OrderDTO.class);
        orderService.create(order);
        log.debug("Получен и записан в БД ордер {}", order.toString());
        if (Boolean.TRUE.equals(checkDish(order.getDishId()))) {
            apiService.setOrderStatus(order.getId(), new Status(4));
        } else {
            apiService.setOrderStatus(order.getId(), new Status(2));
        }
    }

    Boolean checkDish(Integer dishId) {
        return dishService.getById(dishId).isEmpty();
    }
}