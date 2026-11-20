package com.quickcommerce.engine.customer.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddToCartRequest {

    @NotNull
    private long product_id;

    @NotNull
    private int quantity;
}
