package com.quickcommerce.engine.inventory.dto;

import com.quickcommerce.engine.darkstore.model.DarkStore;
import com.quickcommerce.engine.product.model.Product;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddProductToInventoryRequest {

    @NotNull
    private long darkStoreId;

    @NotNull
    private long productId;

    @NotNull
    private Integer onHandQuantity;
}
