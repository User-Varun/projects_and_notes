package com.quickcommerce.engine.darkstore.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AddDarkStoreResponse {

    private long darkStoreId;

    public AddDarkStoreResponse(long darkStoreId){
        this.darkStoreId = darkStoreId;
    }

}
