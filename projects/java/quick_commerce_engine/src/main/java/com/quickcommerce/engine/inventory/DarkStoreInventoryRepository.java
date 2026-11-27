package com.quickcommerce.engine.inventory;

import com.quickcommerce.engine.darkstore.model.DarkStore;
import com.quickcommerce.engine.inventory.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DarkStoreInventoryRepository extends JpaRepository<InventoryItem, Long> {

    Optional<List<InventoryItem>> findAllByDarkStoreId(DarkStore store);

    Optional<InventoryItem> findByDarkStoreIdAndProductId(long darkStoreId , long productId);
}
