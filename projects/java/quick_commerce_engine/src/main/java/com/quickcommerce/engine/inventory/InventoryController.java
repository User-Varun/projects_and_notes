package com.quickcommerce.engine.inventory;

import com.quickcommerce.engine.inventory.dto.AddProductToInventoryRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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

    private DarkStoreInventoryService darkStoreInventoryService;

    public ResponseEntity<String> addProductToInventory(@Valid @RequestBody AddProductToInventoryRequest request){
        darkStoreInventoryService.addProductToInventory(request);
        return ResponseEntity.ok().body("Product Added to Inventory Successfully!");
    }

}
