package org.qj.veggieexpress.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Builder
public class Order {
    private UUID orderID;
    private List<OrderItem> orderContent;
    private UUID customerID;
    private String note;
    private String deliveryAddress;

}
