package com.quickcommerce.engine.product;

import com.quickcommerce.engine.product.dto.AddProductToSystemRequest;
import com.quickcommerce.engine.product.dto.AddProductToSystemResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping()
    public ResponseEntity<AddProductToSystemResponse> addProductToSystem(@Valid @RequestBody AddProductToSystemRequest req){
        AddProductToSystemResponse res  = productService.addProduct(req);
        return ResponseEntity.ok().body(res);
    }
}
