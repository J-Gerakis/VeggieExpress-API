package org.qj.veggieexpress.controller.dto;

import org.qj.veggieexpress.entity.OrderItem;

import java.util.List;
import java.util.UUID;

public record NewOrderRequestDTO(
        UUID customerId,
        List<OrderItem> content,
        String deliveryNote
) {
}
