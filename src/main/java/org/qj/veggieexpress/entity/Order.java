package org.qj.veggieexpress.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@Builder
public class Order {
    private UUID orderID;
    private Set<OrderItem> orderContent;
    private UUID customerID;
    private String note;
    private String deliveryAddress;
    private LocalDateTime createdOn;
    private LocalDateTime deliveredOn;

}
