package org.qj.veggieexpress.repository.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "Order")
@Getter
@Setter
public class OrderDAO {
    @Id
    @Column(name = "order_id")
    String orderId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    CustomerDAO customer;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name ="order_id")
    Set<OrderItemDAO> orderItemDAO;

    public OrderDAO() {}
}
