package com.quickcommerce.engine.customer.model;

import jakarta.persistence.*;
import com.quickcommerce.engine.product.model.Product;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer_cart")
@Data
public class CustomerCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "customer_id",
            nullable = false,
            unique = true
    )
    private CustomerProfile customer;


    // many product can exist in one cart
    @OneToMany(
            mappedBy = "cart",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<CartItem> items = new ArrayList<>();
}
