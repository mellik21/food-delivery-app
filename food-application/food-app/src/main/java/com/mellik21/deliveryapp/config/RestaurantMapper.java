package com.mellik21.deliveryapp.config;

import com.mellik21.deliveryapp.api.dto.RestaurantDto;
import com.mellik21.deliveryapp.model.Restaurant;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface RestaurantMapper {

    Restaurant toRestaurant(RestaurantDto restaurantDto);

    RestaurantDto toRestaurantDto(Restaurant restaurant);

}
