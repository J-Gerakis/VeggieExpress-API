package org.qj.veggieexpress.controller;

import org.qj.veggieexpress.entity.Item;
import org.qj.veggieexpress.service.ItemService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public class OrderController {

    private final ItemService itemService;

    public OrderController(ItemService itemService) {
        this.itemService = itemService;
    }

    @QueryMapping
    public List<Item> listAllItems() {
        return itemService.getAll();
    }

    @QueryMapping
    public Item getItemById(@Argument String id) {
        return itemService.getById(UUID.fromString(id));
    }

    @MutationMapping
    public String addItem(@Argument String name, @Argument String description) {
        return itemService.save(name, description).toString();
    }
}
