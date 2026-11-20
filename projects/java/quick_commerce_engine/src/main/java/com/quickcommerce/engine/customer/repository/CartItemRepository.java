package com.quickcommerce.engine.customer.repository;

import com.quickcommerce.engine.customer.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem , Long> {

    Optional<CartItem> findByCartIdAndProductId(long cartId , long productId);
}
