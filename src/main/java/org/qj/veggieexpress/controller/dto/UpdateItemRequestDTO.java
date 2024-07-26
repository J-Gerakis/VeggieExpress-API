package org.qj.veggieexpress.controller.dto;

import java.util.UUID;

public record UpdateItemRequestDTO(
        UUID itemId,
        String itemNewName,
        String itemNewDescription
) {
}
