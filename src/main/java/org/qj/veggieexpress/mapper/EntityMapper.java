package org.qj.veggieexpress.mapper;

import org.qj.veggieexpress.entity.Item;
import org.qj.veggieexpress.repository.dao.ItemDAO;

import java.util.UUID;

public class EntityMapper {
    public static Item map(ItemDAO dao) {
        return Item.builder()
                .itemId(UUID.fromString(dao.getItemId()))
                .itemName(dao.getItemName())
                .itemDescription(dao.getItemDesc())
                .itemAvailable(dao.isItemAvailable())
                .build();
    }

    public static ItemDAO map(Item item) {
        ItemDAO dao = new ItemDAO();
        dao.setItemId(item.getItemId().toString());
        dao.setItemName(item.getItemName());
        dao.setItemDesc(item.getItemDescription());
        dao.setItemAvailable(item.isItemAvailable());
        return dao;
    }
}
