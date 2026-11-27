package com.quickcommerce.engine.inventory.model;

import com.quickcommerce.engine.darkstore.model.DarkStore;
import com.quickcommerce.engine.product.model.Product;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    private DarkStore darkStore;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    private Integer onHandQuantity;

    private Integer reservedQuantity;

    // something to related with @Version
}
