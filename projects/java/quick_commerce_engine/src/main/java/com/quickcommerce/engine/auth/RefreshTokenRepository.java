package com.quickcommerce.engine.auth;

import com.quickcommerce.engine.auth.model.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken , Long> {
//    Optional<RefreshToken> findByTokenIdAndRevokedFalse(String tokenId);
}
