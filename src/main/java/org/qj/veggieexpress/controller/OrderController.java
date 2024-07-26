package org.qj.veggieexpress.controller;

import org.qj.veggieexpress.controller.dto.NewOrderItemRequestDTO;
import org.qj.veggieexpress.controller.dto.NewOrderRequestDTO;
import org.qj.veggieexpress.entity.Message;
import org.qj.veggieexpress.entity.Order;
import org.qj.veggieexpress.exception.VeggieErrorException;
import org.qj.veggieexpress.exception.VeggieNotFoundException;
import org.qj.veggieexpress.service.OrderService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @QueryMapping
    public Order getOrderById(@Argument UUID id) throws VeggieNotFoundException { //replace with custom ex
        Optional<Order> order = orderService.getOrderById(id);
        if (order.isPresent()) {
            return order.get();
        } else {
            throw new VeggieNotFoundException();
        }
    }

    @QueryMapping
    public List<Order> listAllOrders() {
        return orderService.getAllOrders();
    }

    @MutationMapping
    public UUID createOrder(@Argument NewOrderRequestDTO orderRequest) {
        return orderService.createOrder(orderRequest);
    }

    @MutationMapping
    public Message addItemToOrder(@Argument NewOrderItemRequestDTO itemToAdd) {
        orderService.addToOrder(itemToAdd);
        return new Message("item added to order");
    }

}
