package com.quickcommerce.engine.customer.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "customer_addresses")
@Data
public class CustomerAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal longitude;

    private BigDecimal latitude;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false , name = "customer_id")
    private CustomerProfile customer;

    private Boolean is_default;
}
