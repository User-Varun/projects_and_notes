package com.quickcommerce.engine.customer;

import com.quickcommerce.engine.auth.service.CustomUserDetails;
import com.quickcommerce.engine.auth.service.MyUserDetailsService;
import com.quickcommerce.engine.customer.dto.AddToCartRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class CustomerController {

    private  CustomerService customerService;
    /**
     * 1.A customer can browse products.(dark-store will be assgined once the user places product into cart ( lock refreshes every 10 min for items in the cart)
     * 2.Add product to cart
     * 3.place order
     * 4.track order
     * 
     *
     *
     *
     */


    /**
     * Gets Product into 10 items with pagination and different page for home
     */
    @GetMapping
    public void getProducts(){}

    @PostMapping
    public ResponseEntity<String> addProductToCart(@AuthenticationPrincipal CustomUserDetails user, @Valid @RequestBody AddToCartRequest request){

        // customer adds product to the cart , show the updated cart
        customerService.addProductToCart(user.getId(), request);

        return ResponseEntity.ok().body("product added successfully!");
    }

    
}
