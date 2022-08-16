package com.github.mellik21.resources;

import com.github.foodapp.api.OrderApi;
import com.github.foodapp.api.dto.OrderDto;
import com.github.mellik21.config.OrderMapper;
import com.github.mellik21.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
public class OrderController implements OrderApi {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderController(OrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @Override
    public List<OrderDto> getOrdersList() {
        return orderService.getOrdersList().stream()
                .map(orderMapper::toOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto getOrder(String orderId) {
        return orderMapper.toOrderDto(orderService.getOrder(Long.parseLong(orderId)));
    }

    @Override
    public void createOrder(OrderDto orderDto) {
        orderService.createOrder(orderMapper.toOrder(orderDto));
    }

    @Override
    public void updateOrder(OrderDto orderDto) {
        orderService.updateOrder(orderMapper.toOrder(orderDto));
    }

    @Override
    public void deleteOrder(OrderDto orderDto) {
        orderService.deleteOrder(orderMapper.toOrder(orderDto));
    }
}
