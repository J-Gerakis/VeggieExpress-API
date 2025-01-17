package org.qj.veggieexpress.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
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

    public ItemRepository() { }

    public List<Item> findAll() {
        TypedQuery<ItemDAO> query1 = entityManager.createNamedQuery("Item.getAllItem", ItemDAO.class);
        return query1.getResultList().stream().map(EntityMapper::map).toList();
    }

    public List<Item> findByName(String name) {
        TypedQuery<ItemDAO> squery = entityManager.createNamedQuery("Item.getItemByName", ItemDAO.class)
                .setParameter("name", "%"+name+"%");

        return squery.getResultList().stream().map(EntityMapper::map).toList();
    }

    public UUID addItem(Item item) {
        ItemDAO dao = EntityMapper.map(item);
        entityManager.persist(dao);
        entityManager.flush();
        return dao.getItemId();
    }

    public Optional<Item> findItemById(UUID id) {
        ItemDAO dao = entityManager.find(ItemDAO.class, id.toString());
        if (dao == null) { return Optional.empty(); }
        return Optional.of(EntityMapper.map(dao));
    }

    public void updateItem(Item item) {
        ItemDAO dao = entityManager.find(ItemDAO.class, item.getItemId());
        if (dao == null) { return ; }
        if(item.getItemName() != null) {
            dao.setItemName(item.getItemName());
        }
        if(item.getItemDescription() != null) {
            dao.setItemDesc(item.getItemDescription());
        }

        entityManager.merge(dao);
    }

    public void updateItemAvailability(UUID id, boolean availability) {
        ItemDAO dao = entityManager.find(ItemDAO.class, id);
        if (dao == null) { return ; }
        dao.setItemAvailable(availability);
        entityManager.merge(dao);
    }

}
