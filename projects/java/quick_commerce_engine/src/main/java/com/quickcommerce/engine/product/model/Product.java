package com.quickcommerce.engine.product.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false )
    private String name;

    @Column(nullable = false )
    private String category;

    @Column(nullable = false )
    private Double price;

    @Column(nullable = false )
    private Boolean active;
}
