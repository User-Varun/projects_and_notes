package com.quickcommerce.engine.inventory;

import com.quickcommerce.engine.inventory.dto.AddProductToInventoryRequest;
import com.quickcommerce.engine.inventory.dto.AddProductToInventoryResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 Responsibilties

 <p>
  Handles store specific inventory management
 </p>
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {

    private final DarkStoreInventoryService darkStoreInventoryService;

    @PostMapping()
    public ResponseEntity<AddProductToInventoryResponse> addProduct(@Valid @RequestBody AddProductToInventoryRequest request){

        AddProductToInventoryResponse res  = darkStoreInventoryService.addProductToInventory(request);
        return ResponseEntity.ok().body(res);
    }

    public void getProductQuantity(){

    }

}
