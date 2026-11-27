package com.quickcommerce.engine.product;


import com.quickcommerce.engine.product.dto.AddProductToSystemRequest;
import com.quickcommerce.engine.product.dto.AddProductToSystemResponse;
import com.quickcommerce.engine.product.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public AddProductToSystemResponse addProduct(AddProductToSystemRequest request){
        Product darkStoreProduct = new Product();

        darkStoreProduct.setName(request.getName());
        darkStoreProduct.setPrice(request.getPrice());
        darkStoreProduct.setCategory(request.getCategory());
        darkStoreProduct.setActive(true);

        Product saved = productRepository.save(darkStoreProduct);

        return new AddProductToSystemResponse(saved.getId());
    }
}
