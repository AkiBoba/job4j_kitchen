package ru.job4j.job4j_kitchen.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.job4j.job4j_kitchen.model.Status;

@Service
@RequiredArgsConstructor
public class APIService {

    @Value("${order.api-url}")
    private String url;

    private final RestTemplate client;

    public Void setOrderStatus(Integer id, Status status) {
        String uri = String.format("%s%s/%d", url, "setstatus", id);
        return client.postForObject(uri, status, void.class);
    }
}
