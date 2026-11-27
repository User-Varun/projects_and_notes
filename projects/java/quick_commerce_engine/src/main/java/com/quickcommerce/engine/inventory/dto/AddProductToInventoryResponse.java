package com.quickcommerce.engine.inventory.dto;

import lombok.Data;

@Data
public class AddProductToInventoryResponse {

    private long productId;

    public AddProductToInventoryResponse(long productId){
        this.productId = productId;
    }
}
