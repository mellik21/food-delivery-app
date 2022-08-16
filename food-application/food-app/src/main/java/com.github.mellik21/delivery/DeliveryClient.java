package com.github.mellik21.delivery;


import com.github.foodapp.api.dto.DeliveryOrderDto;
import com.github.foodapp.api.dto.OrderDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DeliveryClient {

    private static final String DELIVERY_CREATE_APP_URL = "localhost:8087/v1/create";

    public DeliveryOrderDto createOrder(OrderDto orderDto) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<OrderDto> request = new HttpEntity<>(orderDto);

        ResponseEntity<DeliveryOrderDto> response = restTemplate
                .exchange(DELIVERY_CREATE_APP_URL, HttpMethod.POST, request, DeliveryOrderDto.class);

        return response.getBody();
    }

}
