package com.example.ch8_ex2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ch8_ex2.model.Product;

@Service
public class ProductService {
    
    private List<Product> products = new ArrayList<>();


    public List<Product> findAll(){
        return products;
    }

    public void addProduct(Product product){
        products.add(product);
    }
}
