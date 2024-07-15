package org.qj.veggieexpress.controller;

import org.qj.veggieexpress.service.CustomerService;
import org.springframework.stereotype.Controller;

@Controller
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


}
