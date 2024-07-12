package org.qj.veggieexpress.repository.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "VOrder")
@Getter
@Setter
public class OrderDAO {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID orderId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    CustomerDAO customer;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name ="order_id")
    Set<OrderItemDAO> orderItemDAO;

    @Column(name = "status")
    Integer status;

    @Column(name = "paid")
    Boolean paid;

    @Column(name = "created_on")
    LocalDateTime createdOn;

    @Column(name = "delivered_on")
    LocalDateTime deliveredOn;

    public OrderDAO() {}
}
