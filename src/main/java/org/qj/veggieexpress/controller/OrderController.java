package org.qj.veggieexpress.controller;

import org.qj.veggieexpress.entity.Order;
import org.qj.veggieexpress.service.OrderService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @QueryMapping
    public Order getOrderById(@Argument String id) {
        UUID uuid = UUID.fromString(id);
        return orderService.getOrderById(uuid);
    }
}
