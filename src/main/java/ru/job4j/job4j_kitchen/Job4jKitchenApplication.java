package ru.job4j.job4j_kitchen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;


@SpringBootApplication
@Configuration
@EnableKafka
public class Job4jKitchenApplication {

    public static void main(String[] args) {
        SpringApplication.run(Job4jKitchenApplication.class, args);
        System.out.println("KitchenApplication run");
    }

}
