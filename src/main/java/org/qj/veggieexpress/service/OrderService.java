package org.qj.veggieexpress.service;

import org.qj.veggieexpress.controller.dto.NewOrderRequestDTO;
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

    public UUID createOrder(NewOrderRequestDTO orderRequestDTO) {
        return orderRepository.create(UUID.fromString(orderRequestDTO.customerId()));
    }
}
