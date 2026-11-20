package com.quickcommerce.engine.auth.model;

import com.quickcommerce.engine.user.model.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Data
public class RefreshToken {
    @Id @GeneratedValue private Long id;

    @Column(nullable = false , unique = true)
    private String tokenId;


    @ManyToOne(optional = false, fetch = FetchType.LAZY)      // need to find what this means here
    private User user;

    @Column(nullable = false )
    private String tokenHash;

    @Column(nullable = false )
    private Instant expiresAt;

    private boolean revoked;

    @Column(nullable = false , updatable = false)
    private Instant createdAt;

    @PrePersist
    private void onCreate(){
        this.createdAt = Instant.now();
    }



}
