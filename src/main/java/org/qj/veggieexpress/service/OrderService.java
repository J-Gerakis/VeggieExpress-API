package org.qj.veggieexpress.service;

import org.qj.veggieexpress.controller.dto.NewOrderItemRequestDTO;
import org.qj.veggieexpress.controller.dto.NewOrderRequestDTO;
import org.qj.veggieexpress.entity.Item;
import org.qj.veggieexpress.entity.Order;
import org.qj.veggieexpress.repository.ItemRepository;
import org.qj.veggieexpress.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    public OrderService(OrderRepository orderRepository, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
    }

    public Optional<Order> getOrderById(UUID id) {
        return orderRepository.getOrderById(id);
    }

    public List<Order> getAllOrders() {
        return orderRepository.getAll();
    }

    public UUID createOrder(NewOrderRequestDTO orderRequestDTO) {
        return orderRepository.create(orderRequestDTO);
    }

    public void addToOrder(NewOrderItemRequestDTO orderItemRequestDTO) {
        //check order existence first
        Optional<Order> order = orderRepository.getOrderById(orderItemRequestDTO.orderId());
        Optional<Item> item = itemRepository.findItemById(orderItemRequestDTO.itemId());

        if(order.isPresent() && item.isPresent()) {
            orderRepository.addToOrder(orderItemRequestDTO);
        }
        //else throw exception
    }
}
