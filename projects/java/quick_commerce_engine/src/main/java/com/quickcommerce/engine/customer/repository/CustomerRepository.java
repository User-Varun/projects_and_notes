package com.quickcommerce.engine.customer.repository;

import com.quickcommerce.engine.customer.model.CustomerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerProfile , Long> {
}
