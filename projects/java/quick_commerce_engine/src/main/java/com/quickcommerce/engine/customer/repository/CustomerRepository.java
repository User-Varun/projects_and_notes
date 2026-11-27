package com.quickcommerce.engine.customer.repository;

import com.quickcommerce.engine.customer.model.CustomerProfile;
import com.quickcommerce.engine.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerProfile , Long> {
    List<CustomerProfile> user(User user);

    Optional<CustomerProfile> findByUserId(long userId);

    long user(User user);
}
