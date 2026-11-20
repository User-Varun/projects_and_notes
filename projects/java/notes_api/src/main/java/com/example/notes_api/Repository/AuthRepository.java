package com.example.notes_api.Repository;

import com.example.notes_api.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<User , Long> {

    Optional<User> findByUsername(String username);
}

