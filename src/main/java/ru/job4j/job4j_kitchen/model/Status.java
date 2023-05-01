package ru.job4j.job4j_kitchen.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * id = 1 -Принят
 * id = 2 -В работе
 * id = 3 -Готов
 * id = 4 -Отменен
 */
@Data
@Entity
@Table(name = "status")
public class Status {
    @Id
    private Integer id;
    private String name;

    public Status(Integer id) {
        this.id = id;
    }

    public Status() {

    }
}
