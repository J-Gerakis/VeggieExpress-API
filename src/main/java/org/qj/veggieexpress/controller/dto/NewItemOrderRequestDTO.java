package org.qj.veggieexpress.controller.dto;

import java.util.UUID;

public record NewItemOrderRequestDTO(
        UUID itemId,
        UUID orderId,
        int quantity
)
{ }
