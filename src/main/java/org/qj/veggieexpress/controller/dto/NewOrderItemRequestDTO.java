package org.qj.veggieexpress.controller.dto;

import java.util.UUID;

public record NewOrderItemRequestDTO(
        UUID itemId,
        UUID orderId,
        int quantity
)
{ }
