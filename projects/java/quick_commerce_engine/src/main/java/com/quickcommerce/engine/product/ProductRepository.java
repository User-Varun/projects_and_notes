package com.quickcommerce.engine.product;

import com.quickcommerce.engine.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product , Long> {
}
