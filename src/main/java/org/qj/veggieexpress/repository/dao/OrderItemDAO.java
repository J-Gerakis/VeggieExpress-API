package org.qj.veggieexpress.repository.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "OrderItem")
@Getter
@Setter
public class OrderItemDAO {

    @Id
    @Column(name = "order_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "order_id")
    String orderId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item_id")
    ItemDAO item;

    @Column(name = "quantity")
    int quantity;

    public OrderItemDAO() {}
}
