package org.qj.veggieexpress.controller.dto;

public record NewOrderRequestDTO(
        String customerId,
        String orderContent
) {
}
