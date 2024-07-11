package org.qj.veggieexpress.repository.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Customer")
@Getter
@Setter
public class CustomerDAO {

    @Id
    @Column(name="customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long customerId;

    @Column(name = "customer_name")
    String customerName;

    @Column(name = "customer_phone")
    String customerPhone;

    @Column(name = "customer_delivery_address")
    String customerDeliveryAddress;

    @Column(name = "customer_note")
    String customerNote;

    public CustomerDAO() {}
}
