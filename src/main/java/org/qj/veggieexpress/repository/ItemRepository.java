package org.qj.veggieexpress.repository;

import org.qj.veggieexpress.entity.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.spi.ToolProvider.findFirst;

@Repository
public class ItemRepository {

    private List<Item> items;
    //replace with H2 database
    public ItemRepository() {
        //some test values
        items = new ArrayList<>();
        items.add(Item.builder()
                 .itemId(UUID.randomUUID())
                .itemName("Cucumber")
                .itemDescription("")
                .build());

        items.add(Item.builder()
                .itemId(UUID.randomUUID())
                .itemName("Tomato")
                .itemDescription("")
                .build());

        items.add(Item.builder()
                .itemId(UUID.randomUUID())
                .itemName("Watermelon")
                .itemDescription("")
                .build());
    }

    public List<Item> findAll() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Optional<Item> findItemById(UUID id) {
        return items.stream().filter(item -> item.getItemId() == id).findFirst();
    }

}
