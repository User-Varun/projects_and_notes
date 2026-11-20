package com.quickcommerce.engine.inventory;

import com.quickcommerce.engine.inventory.dto.AddProductToInventoryRequest;
import com.quickcommerce.engine.inventory.model.DarkStoreInventory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DarkStoreInventoryService {

    private DarkStoreInventoryRepository darkStoreInventoryRepository;

    public void addProductToInventory(AddProductToInventoryRequest request){
        DarkStoreInventory darkStoreInventoryProduct = new DarkStoreInventory();

        darkStoreInventoryProduct.setDarkStoreId(request.getDarkStoreId());
        darkStoreInventoryProduct.setProductId(request.getProductId());
        darkStoreInventoryProduct.setOnHandQuantity(request.getOnHandQuantity());
        darkStoreInventoryProduct.setReservedQuantity(0); // initially reserved

        darkStoreInventoryRepository.save(darkStoreInventoryProduct);
    }

}
