package com.quickcommerce.engine.product.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Adds product to the system that is used by dark-stores to manage these products.
 */
@Data
public class AddProductToSystemRequest {

    @NotNull
    private String name;

    @NotNull
    private Double price;

    @NotNull
    private String category;
}
