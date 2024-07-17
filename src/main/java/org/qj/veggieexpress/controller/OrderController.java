package org.qj.veggieexpress.controller;

import org.qj.veggieexpress.controller.dto.NewOrderRequestDTO;
import org.qj.veggieexpress.entity.Order;
import org.qj.veggieexpress.service.OrderService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @QueryMapping
    public Order getOrderById(@Argument UUID id) {
        //UUID uuid = UUID.fromString(id);
        return orderService.getOrderById(id);
    }

    @QueryMapping
    public List<Order> listAllOrders() {
        return orderService.getAllOrders();
    }

    @MutationMapping
    public UUID createOrder(@Argument NewOrderRequestDTO orderRequest) {
        return orderService.createOrder(orderRequest);
    }

}
