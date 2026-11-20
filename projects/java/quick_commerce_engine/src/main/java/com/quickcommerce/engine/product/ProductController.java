package com.quickcommerce.engine.product;

import com.quickcommerce.engine.product.dto.AddProductToSystemRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Responsibilites
 *
 * <p>
 *
 * 1. CRUD Product
 * </p>
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private ProductService productService;

    /**
     * Adds the Product to the system, this later used for adding products to dark-store specific inventories.
     * @param request
     * @return ResponseEntity
     */
    @PostMapping
    public ResponseEntity<String> addProduct(@Valid @RequestBody AddProductToSystemRequest request){
        productService.addProduct(request);
        return ResponseEntity.ok().body("Product added in the system successfully!");
    }

}
