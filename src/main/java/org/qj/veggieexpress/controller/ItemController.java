package org.qj.veggieexpress.controller;

import org.qj.veggieexpress.controller.dto.NewItemRequestDTO;
import org.qj.veggieexpress.controller.dto.UpdateItemRequestDTO;
import org.qj.veggieexpress.entity.Item;
import org.qj.veggieexpress.entity.Message;
import org.qj.veggieexpress.exception.VeggieNotFoundException;
import org.qj.veggieexpress.service.ItemService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
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
    public Item getItemById(@Argument String id) throws VeggieNotFoundException {
        Optional<Item> optItem = itemService.getById(UUID.fromString(id));
        if (optItem.isPresent()) {
            return optItem.get();
        } else throw new VeggieNotFoundException();
    }

    @MutationMapping
    public UUID addItem(@Argument NewItemRequestDTO itemRequest) {
        return itemService.create(itemRequest);
    }

    @MutationMapping
    public Message updateItem(@Argument UpdateItemRequestDTO itemRequest) {
        itemService.update(itemRequest);
        return new Message("item updated");
    }

    @MutationMapping
    public Message changeItemAvailability(@Argument UUID itemId, @Argument boolean isAvailable) {
        itemService.updateAvailability(itemId, isAvailable);
        return new Message("item availability updated");
    }
}
