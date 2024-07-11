package org.qj.veggieexpress.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Builder
public class Customer {
    private UUID customerId;
    private String name;
    private String phone;
    private String address;
    private String note;
}
