package org.qj.veggieexpress.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class Item {
    private UUID itemId;
    private String itemName;
    private String itemDescription;
}
