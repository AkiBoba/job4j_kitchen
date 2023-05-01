package ru.job4j.job4j_kitchen.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.job4j_kitchen.model.OrderDTO;

public interface OrderRepository extends CrudRepository<OrderDTO, Integer> {
}
