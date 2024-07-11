package org.qj.veggieexpress.repository.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.qj.veggieexpress.entity.Item;

import java.util.UUID;

@Entity
@Table(name = "Item")
@Getter
@Setter
@NamedQuery(name="getAllItem", query="select i from ItemDAO i")
@NamedNativeQuery(name="getItemByName", query="select * from Item i where i.item_name like :name", resultClass = ItemDAO.class)
public class ItemDAO {

    @Id
    @Column(name="item_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID itemId;

    @Column(name="item_name", nullable = false)
    String itemName;

    @Column(name="item_description", nullable = false)
    String itemDesc;

    @Column(name="item_available", nullable = false)
    boolean itemAvailable;

    public ItemDAO() {}
}
