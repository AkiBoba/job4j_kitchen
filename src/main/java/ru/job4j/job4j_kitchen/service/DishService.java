package ru.job4j.job4j_kitchen.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.job4j_kitchen.model.Dish;
import ru.job4j.job4j_kitchen.repository.DishRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DishService {
    private final DishRepository repository;

    public Optional<Dish> getById(Integer dishId) {
        return repository.findById(dishId);
    }

}
