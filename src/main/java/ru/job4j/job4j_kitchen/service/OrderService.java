package ru.job4j.job4j_kitchen.service;

import org.springframework.stereotype.Service;
import ru.job4j.job4j_kitchen.domain.OrderDTO;
import ru.job4j.job4j_kitchen.repository.OrderRepository;

@Service
public class OrderService {
    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public void create(OrderDTO order) {
        var savedOrder = repository.save(order);
    }

}
