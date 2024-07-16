package org.qj.veggieexpress.service;

import org.qj.veggieexpress.controller.dto.NewCustomerDTO;
import org.qj.veggieexpress.entity.Customer;
import org.qj.veggieexpress.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public UUID create(NewCustomerDTO customerDTO) {
        Customer customer = Customer.builder()
                .name(customerDTO.name())
                .address(customerDTO.address())
                .phone(customerDTO.phone())
                .note(customerDTO.note())
                .build();
        return customerRepository.addCustomer(customer);
    }

}
