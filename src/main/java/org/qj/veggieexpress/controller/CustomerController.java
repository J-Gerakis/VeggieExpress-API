package org.qj.veggieexpress.controller;

import org.qj.veggieexpress.controller.dto.NewCustomerDTO;
import org.qj.veggieexpress.entity.Customer;
import org.qj.veggieexpress.service.CustomerService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @QueryMapping
    public Customer getCustomerById(@Argument UUID id) {
        return customerService.getCustomerById(id);
    }

    @QueryMapping
    public Customer getCustomerByPhone(@Argument String phone) {
        return customerService.getCustomerByPhone(phone);
    }

    @MutationMapping
    public UUID createCustomer(@Argument NewCustomerDTO customerRequest) {
        return customerService.create(customerRequest);
    }



}
