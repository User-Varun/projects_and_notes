package com.quickcommerce.engine.customer.repository;

import com.quickcommerce.engine.customer.model.CustomerCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerCartRepository extends JpaRepository<CustomerCart , Long> {

    Optional<CustomerCart> findByCustomerId(Long customerId);
}
