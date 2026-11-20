package com.quickcommerce.engine.darkstore.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "dark_store")
public class DarkStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;


    @Column(precision = 9 , scale = 6 , nullable = false)
    private BigDecimal latitude;

    @Column(precision = 10 , scale = 6 , nullable = false)
    private BigDecimal longitude;


    @Column(name = "delivery_radius_meters" , nullable = false)
    private Integer deliveryRadiusMeters;

    @Column(nullable = false)
    private Boolean active;
}
