package com.quickcommerce.engine.product;


import com.quickcommerce.engine.product.dto.AddProductToSystemRequest;
import com.quickcommerce.engine.product.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    public void addProduct(AddProductToSystemRequest request){
        Product darkStoreProduct = new Product();

        darkStoreProduct.setName(request.getName());
        darkStoreProduct.setPrice(request.getPrice());
        darkStoreProduct.setCategory(request.getCategory());
        darkStoreProduct.setActive(true);

        productRepository.save(darkStoreProduct);
    }
}
