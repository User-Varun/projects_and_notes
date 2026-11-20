package com.quickcommerce.engine.inventory.model;

import com.quickcommerce.engine.darkstore.model.DarkStore;
import com.quickcommerce.engine.product.model.Product;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class DarkStoreInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "dark_store_id", nullable = false)
    private DarkStore darkStoreId;

    @ManyToOne
    @JoinColumn(name = "product_id" , nullable = false)
    private Product productId;   // will lazy load this later

    @Column(name = "on_hand_quantity" , nullable = false)
    private Integer onHandQuantity;

    @Column(name = "reserved_quantity" , nullable = false)
    private Integer reservedQuantity;

    // something to related with @Version
}
