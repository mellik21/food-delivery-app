package com.github.mellik21.service;

import com.github.foodapp.api.dto.DeliveryOrderDto;
import com.github.mellik21.config.OrderMapper;
import com.github.mellik21.dao.ClientDao;
import com.github.mellik21.dao.OrderDao;
import com.github.mellik21.delivery.DeliveryClient;
import com.github.mellik21.dto.FoodAppOrderDto;
import com.github.mellik21.model.Order;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Log4j2
public class OrderService {

    private final OrderDao orderDao;
    private final DeliveryClient deliveryClient;
    private final OrderMapper orderMapper;
    private final ClientDao clientDao;

    @Autowired
    public OrderService(OrderDao orderDao, DeliveryClient deliveryClient, OrderMapper orderMapper, ClientDao clientDao) {
        this.orderDao = orderDao;
        this.deliveryClient = deliveryClient;
        this.orderMapper = orderMapper;
        this.clientDao = clientDao;
    }

    @Transactional
    public void createOrder(Order order) {
        //update order
        order.setCreatedWhen(LocalDateTime.now());
        order.setClient(clientDao.getOne(1L));

        Order savedOrder = orderDao.save(order);
        log.info("### Saved order\n" +order+"\n");

        //create requestDto
        FoodAppOrderDto requestDto = orderMapper.toFoodAppOrderDto(order);
        requestDto.setCreationDate(savedOrder.getCreatedWhen());
        //    requestDto.setClientName(savedOrder.getClient().getName);

        //send request
        DeliveryOrderDto deliveryClientOrder = deliveryClient.createOrder(requestDto);
        /*
        По идее здесь мы сохраняем больше информации о заказе!
         */
        savedOrder.setDeliveryOrderId(deliveryClientOrder.getId());
        savedOrder.setCourierName(deliveryClientOrder.getCourierName());
        // savedOrder.setExpectedDeliveryTime(deliveryClientOrder.getExpectedDeliveryTime());

        orderDao.save(savedOrder);
        log.info("### Saved order from delivery\n" +order+"\n");
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
