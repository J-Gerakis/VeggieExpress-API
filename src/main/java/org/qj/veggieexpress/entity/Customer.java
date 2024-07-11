package org.qj.veggieexpress.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Customer {
    private Long customerId;
    private String name;
    private String phone;
    private String address;
    private String note;
}
