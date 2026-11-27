package com.quickcommerce.engine.inventory;

import com.quickcommerce.engine.common.exceptions.DarkstoreNotFoundException;
import com.quickcommerce.engine.common.exceptions.ProductNotFoundException;
import com.quickcommerce.engine.darkstore.DarkStoreRepository;
import com.quickcommerce.engine.darkstore.model.DarkStore;
import com.quickcommerce.engine.inventory.dto.AddProductToInventoryRequest;
import com.quickcommerce.engine.inventory.dto.AddProductToInventoryResponse;
import com.quickcommerce.engine.inventory.model.InventoryItem;
import com.quickcommerce.engine.product.ProductRepository;
import com.quickcommerce.engine.product.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DarkStoreInventoryService {

    private final DarkStoreInventoryRepository darkStoreInventoryRepository;
    private final DarkStoreRepository darkStoreRepository;
    private final ProductRepository productRepository;

    public AddProductToInventoryResponse addProductToInventory(AddProductToInventoryRequest request){

        InventoryItem inventoryItemProduct = new InventoryItem();

        DarkStore darkStore = darkStoreRepository.findById(request.getDarkStoreId())
                .orElseThrow(() -> new DarkstoreNotFoundException(String.valueOf(request.getDarkStoreId())));

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new ProductNotFoundException(String.valueOf(request.getProductId())));


        inventoryItemProduct.setDarkStore(darkStore);
        inventoryItemProduct.setProduct(product);
        inventoryItemProduct.setOnHandQuantity(request.getOnHandQuantity());
        inventoryItemProduct.setReservedQuantity(0); // initially reserved

        InventoryItem saved = darkStoreInventoryRepository.save(inventoryItemProduct);

        return new AddProductToInventoryResponse(saved.getId()); // id of the inventory item
    }

}
