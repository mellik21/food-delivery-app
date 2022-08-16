package com.github.mellik21.service;

import com.github.foodapp.api.dto.DeliveryOrderDto;
import com.github.mellik21.config.OrderMapper;
import com.github.mellik21.dao.OrderDao;
import com.github.mellik21.delivery.DeliveryClient;
import com.github.mellik21.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderService {

    private final OrderDao orderDao;
    private final DeliveryClient deliveryClient;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderService(OrderDao orderDao, DeliveryClient deliveryClient, OrderMapper orderMapper) {
        this.orderDao = orderDao;
        this.deliveryClient = deliveryClient;
        this.orderMapper = orderMapper;
    }

    @Transactional
    public void createOrder(Order order) {
        Order savedOrder = orderDao.save(order);
        DeliveryOrderDto deliveryClientOrder = deliveryClient.createOrder(orderMapper.toOrderDto(order));
        System.out.println(deliveryClientOrder.toString());
        /*
        По идее здесь мы сохраняем больше информации о заказе!
         */
        savedOrder.setDeliveryOrderId(deliveryClientOrder.getId());
        savedOrder.setCourierName(deliveryClientOrder.getCourierName());
       // savedOrder.setExpectedDeliveryTime(deliveryClientOrder.getExpectedDeliveryTime());
    }

    public List<Order> getOrdersList() {
        return orderDao.findAll();
    }

    public Order getOrder(Long orderId) {
        return orderDao.findById(orderId).orElseThrow(
                () -> new RuntimeException("Order with id=" + orderId + "doesn't exist"));
    }

    public void updateOrder(Order order) {
        orderDao.save(order);
    }

    public void deleteOrder(Order order) {
        orderDao.delete(order);
    }
}
