package ru.job4j.job4j_kitchen.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.job4j.job4j_kitchen.domain.OrderDTO;

@Service
@Slf4j
@RequiredArgsConstructor
public class KitchenService {
    private final OrderService orderService;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @KafkaListener(topics = "job4j_orders")
    public void receiveOrder(String newOrder) throws JsonProcessingException {
        OrderDTO order = OBJECT_MAPPER.readValue(newOrder, OrderDTO.class);
        orderService.create(order);
        log.debug("Получен и записан в БД ордер {}", order.toString());
    }
}