package com.quickcommerce.engine.customer.model;

import com.quickcommerce.engine.product.model.Product;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "cart_item" , uniqueConstraints = {
        @UniqueConstraint(
                columnNames = {"cart_id" , "product_id"}
        )
})
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id" , nullable = false)
    private CustomerCart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id" , nullable = false)
    private Product product;

    @Column(nullable = false)
    private Integer quantity;
}
