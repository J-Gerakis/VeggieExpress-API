package org.qj.veggieexpress.service;

import org.qj.veggieexpress.controller.dto.NewItemRequestDTO;
import org.qj.veggieexpress.controller.dto.UpdateItemDTO;
import org.qj.veggieexpress.entity.Item;
import org.qj.veggieexpress.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    public List<Item> search(String term) {
        return itemRepository.findByName(term);
    }

    public void update(UpdateItemDTO updateRequest) {
      Item item = Item.builder()
              .itemId(updateRequest.itemId())
              .itemName(updateRequest.itemNewName())
              .itemDescription(updateRequest.itemNewDescription())
              .build();
      itemRepository.updateItem(item);
    }

    public void updateAvailability(UUID itemId, Boolean availability) {
        itemRepository.updateItemAvailability(itemId, availability);
    }

    public Item getById(UUID id) {
        return itemRepository.findItemById(id).orElse(null);
        //future exception here
    }

    public UUID create(NewItemRequestDTO dto) {
        Item item = Item.builder()
                //.itemId(UUID.randomUUID())
                .itemName(dto.itemName())
                .itemDescription(dto.itemDescription())
                .itemAvailable(true)
                .build();

        return itemRepository.addItem(item);
    }

}
