package org.qj.veggieexpress.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.qj.veggieexpress.entity.Item;
import org.qj.veggieexpress.mapper.EntityMapper;
import org.qj.veggieexpress.repository.dao.ItemDAO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
public class ItemRepository {

    @PersistenceContext
    private EntityManager entityManager;

    //private List<Item> items;
    //replace with H2 database
    public ItemRepository() {
        //some test values
//
//        items = new ArrayList<>();
//        items.add(Item.builder()
//                 .itemId(UUID.randomUUID())
//                .itemName("Cucumber")
//                .itemDescription("")
//                .build());
//
//        items.add(Item.builder()
//                .itemId(UUID.randomUUID())
//                .itemName("Tomato")
//                .itemDescription("")
//                .build());
//
//        items.add(Item.builder()
//                .itemId(UUID.randomUUID())
//                .itemName("Watermelon")
//                .itemDescription("")
//                .build());
    }

    public List<Item> findAll() {
        return entityManager.find();
    }

    public void addItem(Item item) {
        ItemDAO dao = EntityMapper.map(item);
        entityManager.persist(dao);
    }

    public Optional<Item> findItemById(UUID id) {
        //return items.stream().filter(item -> item.getItemId().equals(id)).findFirst();
        ItemDAO dao = entityManager.find(ItemDAO.class, id.toString());
        if (dao == null) { return Optional.empty(); }
        return Optional.of(EntityMapper.map(dao));
    }

}
