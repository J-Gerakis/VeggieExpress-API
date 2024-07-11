package org.qj.veggieexpress.repository.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Item")
@Getter
@Setter
public class ItemDAO {

    @Id
    @Column(name="item_id", nullable = false)
    String itemId;

    @Column(name="item_name", nullable = false)
    String itemName;

    @Column(name="item_description", nullable = false)
    String itemDesc;

    @Column(name="item_available", nullable = false)
    boolean itemAvailable;

    public ItemDAO() {}
}
