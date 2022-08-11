package com.github.mellik21.service;

import com.github.mellik21.dao.OrderDao;
import com.github.mellik21.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderDao orderDao;

    @Autowired
    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void createOrder(Order order) {
        orderDao.save(order);
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
