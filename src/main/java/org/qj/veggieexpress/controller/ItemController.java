package org.qj.veggieexpress.controller;

import org.qj.veggieexpress.controller.dto.NewItemRequestDTO;
import org.qj.veggieexpress.entity.Item;
import org.qj.veggieexpress.service.ItemService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @QueryMapping
    public List<Item> listAllItems() {
        return itemService.getAll();
    }

    @QueryMapping
    public List<Item> searchItem(@Argument("searchTerm") String term) {
        return itemService.search(term);
    }

    @QueryMapping
    public Item getItemById(@Argument String id) {
        return itemService.getById(UUID.fromString(id));
    }

    @MutationMapping
    public UUID addItem(@Argument NewItemRequestDTO itemRequest) {
        return itemService.create(itemRequest);
    }
}
