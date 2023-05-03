package ru.job4j.job4j_kitchen.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.job4j.job4j_kitchen.api.APIService;
import ru.job4j.job4j_kitchen.model.RequestOrderDTO;
import ru.job4j.job4j_kitchen.model.Status;

@Service
@Slf4j
@RequiredArgsConstructor
public class KitchenService {
    private final OrderService orderService;
    private final APIService apiService;
    private final DishService dishService;

    @KafkaListener(topics = "cooked_order")
    public void receiveOrder(RequestOrderDTO order) {
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