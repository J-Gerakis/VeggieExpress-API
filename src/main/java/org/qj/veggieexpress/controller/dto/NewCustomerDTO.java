package org.qj.veggieexpress.controller.dto;

public record NewCustomerDTO(
        String name,
        String phone,
        String address,
        String note
) {
}
