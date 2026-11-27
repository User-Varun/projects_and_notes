package com.quickcommerce.engine.product.dto;

import lombok.Data;

@Data
public class AddProductToSystemResponse {

    private long productId;

    public AddProductToSystemResponse(long productId){
        this.productId = productId;
    }
}
