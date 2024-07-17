package org.qj.veggieexpress.repository.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "Customer")
@Getter
@Setter
@NamedQuery(name="Customer.findByPhone", query="select i from CustomerDAO i where customerPhone = :phone")
public class CustomerDAO {

    @Id
    @Column(name="customer_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID customerId;

    @Column(name = "customer_contact_name")
    String customerName;

    @Column(name = "customer_phone")
    String customerPhone;

    @Column(name = "customer_delivery_address")
    String customerDeliveryAddress;

    @Column(name = "customer_note")
    String customerNote;

    public CustomerDAO() {}
}
