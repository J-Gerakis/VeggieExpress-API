package org.qj.veggieexpress.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class OrderItem {
    private UUID orderRef;
    private Item item;
    private int quantity;
}
