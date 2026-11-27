package com.quickcommerce.engine.user.repository;

import com.quickcommerce.engine.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository

public interface UserRepository extends JpaRepository<User , Long> {

    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
}
