package com.quickcommerce.engine.darkstore;

import com.quickcommerce.engine.darkstore.model.DarkStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DarkStoreRepository extends JpaRepository<DarkStore, Long> {


}
