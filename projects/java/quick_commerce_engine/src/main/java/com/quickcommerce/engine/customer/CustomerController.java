package com.quickcommerce.engine.customer;

import com.quickcommerce.engine.auth.service.CustomUserDetails;
import com.quickcommerce.engine.common.exceptions.DarkstoreNotFoundException;
import com.quickcommerce.engine.common.exceptions.InventoryItemNotFoundException;
import com.quickcommerce.engine.customer.dto.AddToCartRequest;
import com.quickcommerce.engine.customer.dto.PopulateHomePageResponse;
import com.quickcommerce.engine.darkstore.DarkStoreService;
import com.quickcommerce.engine.customer.dto.GetNearestStoreRequest;
import com.quickcommerce.engine.darkstore.model.DarkStore;
import com.quickcommerce.engine.inventory.DarkStoreInventoryRepository;
import com.quickcommerce.engine.inventory.DarkStoreInventoryService;
import com.quickcommerce.engine.inventory.model.InventoryItem;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class CustomerController {

    private  final CustomerService customerService;
    private final DarkStoreService darkStoreService;
    private final DarkStoreInventoryRepository darkStoreInventoryRepository;

    /**
     * Methods
     * 1. show the customer the products from the nearest store ( populate the home page )
     * 2. manage add to cart
     * 3. handle order placed
     * 4. track order using events ( web-sockets )
     * 5. search products ( fast search )
     */

    @PostMapping("/add-to-cart")
    public ResponseEntity<String> addToCart(@Valid @RequestBody AddToCartRequest req, @AuthenticationPrincipal CustomUserDetails userDetails){
        customerService.addProductToCart(userDetails.getId() , req);
        return ResponseEntity.ok().body("product added to cart successfully");
    }

    public void addAddress(){

    }

}
