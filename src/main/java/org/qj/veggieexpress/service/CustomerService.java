package org.qj.veggieexpress.service;

import org.qj.veggieexpress.entity.Customer;
import org.qj.veggieexpress.repository.CustomerRepository;

import java.util.UUID;

public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public UUID create(Customer customer) {
        return customerRepository.addCustomer(customer);
    }

}
