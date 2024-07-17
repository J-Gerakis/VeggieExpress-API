package org.qj.veggieexpress.controller.dto;

import java.util.UUID;

public record UpdateItemDTO(
        UUID itemId,
        String itemNewName,
        String itemNewDescription
) {
}
