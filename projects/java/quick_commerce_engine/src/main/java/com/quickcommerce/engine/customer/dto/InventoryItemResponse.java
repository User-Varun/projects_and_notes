package com.quickcommerce.engine.customer.dto;

import com.quickcommerce.engine.product.model.Product;
import lombok.Data;

@Data
public class InventoryItemResponse {


    // these 2 properties for now, may add reserved quantity if needed by frontend
    private Product productId;

    private Integer onHandQuantity;
}
