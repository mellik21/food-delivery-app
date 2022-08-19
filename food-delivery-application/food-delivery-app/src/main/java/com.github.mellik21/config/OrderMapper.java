package com.github.mellik21.config;

import com.github.foodapp.api.dto.OrderDto;
import com.github.mellik21.dto.FoodAppOrderDto;
import com.github.mellik21.model.Order;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface OrderMapper {

    OrderDto toOrderDto(Order order);

    Order toOrder(OrderDto orderDto);

    FoodAppOrderDto toFoodAppOrderDto(Order order);
}
