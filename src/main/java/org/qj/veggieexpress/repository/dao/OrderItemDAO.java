package org.qj.veggieexpress.repository.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "OrderItem")
@Getter
@Setter
public class OrderItemDAO {

    @Id
    @Column(name = "order_item_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID orderItemId;

    @Column(name = "order_id")
    UUID orderId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item_id")
    ItemDAO item;

    @Column(name = "quantity")
    int quantity;

    public OrderItemDAO() {}
}
