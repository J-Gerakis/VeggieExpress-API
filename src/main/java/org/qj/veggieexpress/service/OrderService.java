package org.qj.veggieexpress.service;

import org.qj.veggieexpress.entity.Order;
import org.qj.veggieexpress.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order getOrderById(UUID id) {
        return orderRepository.getOrderById(id);
    }

    public UUID addOrder(Order order) {
        return orderRepository.save(order);
    }
}
