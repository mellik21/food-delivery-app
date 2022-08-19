package com.mellik21.deliveryapp.resource;

import com.mellik21.deliveryapp.api.RestaurantApi;
import com.mellik21.deliveryapp.api.dto.RestaurantDto;
import com.mellik21.deliveryapp.config.RestaurantMapper;
import com.mellik21.deliveryapp.kafka.RestaurantInfoUpdatedMessageProducer;
import com.mellik21.deliveryapp.kafka.message.RestaurantInfoUpdatedMessage;
import com.mellik21.deliveryapp.model.Restaurant;
import com.mellik21.deliveryapp.service.RestaurantService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RestaurantController implements RestaurantApi {

    private final RestaurantService restaurantService;
    private final RestaurantMapper restaurantMapper;
    private final RestaurantInfoUpdatedMessageProducer orderCreatedMessageProducer;

    public RestaurantController(RestaurantService restaurantService, RestaurantMapper restaurantMapper, RestaurantInfoUpdatedMessageProducer orderCreatedMessageProducer) {
        this.restaurantService = restaurantService;
        this.restaurantMapper = restaurantMapper;
        this.orderCreatedMessageProducer = orderCreatedMessageProducer;
    }

    @Override
    public List<RestaurantDto> getRestaurantsList() {
        return restaurantService.getRestaurantsList().stream()
                .map(restaurantMapper::toRestaurantDto)
                .collect(Collectors.toList());
    }

    @Override
    public RestaurantDto getRestaurant(String restaurantId) {
        return restaurantMapper.toRestaurantDto(
                restaurantService.getRestaurant(Long.valueOf(restaurantId))
        );
    }

    @Override
    public void createRestaurant(RestaurantDto restaurantDto) {
        Restaurant restaurant = restaurantService.createRestaurant(
                restaurantMapper.toRestaurant(restaurantDto));

        orderCreatedMessageProducer.sendMessage(RestaurantInfoUpdatedMessage.builder()
                .orderId(restaurant.getId())
                .build());
    }

    @Override
    public void updateRestaurant(RestaurantDto restaurantDto) {
        restaurantService.updateRestaurant(
                restaurantMapper.toRestaurant(restaurantDto));
    }

    @Override
    public void deleteRestaurant(String id) {
        restaurantService.deleteRestaurant(Long.valueOf(id));
    }
}
