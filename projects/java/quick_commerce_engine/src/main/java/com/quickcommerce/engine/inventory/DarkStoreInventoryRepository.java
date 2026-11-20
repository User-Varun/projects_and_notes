package com.quickcommerce.engine.inventory;

import com.quickcommerce.engine.inventory.model.DarkStoreInventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DarkStoreInventoryRepository extends JpaRepository<DarkStoreInventory , Long> {
}
