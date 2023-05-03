package ru.job4j.job4j_kitchen.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.job4j_kitchen.model.RequestOrderDTO;
import ru.job4j.job4j_kitchen.repository.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository repository;

    public void create(RequestOrderDTO order) {
        repository.save(order);
    }

}
