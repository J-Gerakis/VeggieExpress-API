package org.qj.veggieexpress.service;

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

    public Item getById(UUID id) {
        return itemRepository.findItemById(id).orElse(null);
        //future exception here
    }

    public UUID save(String name, String description) {
        Item item = Item.builder()
                .itemId(UUID.randomUUID())
                        .itemName(name)
                                .itemDescription(description).build();

        itemRepository.addItem(item);
        return item.getItemId();
    }
}
