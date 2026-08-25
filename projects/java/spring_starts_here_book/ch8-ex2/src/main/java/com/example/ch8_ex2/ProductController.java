package com.example.ch8_ex2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ch8_ex2.model.Product;
import com.example.ch8_ex2.service.ProductService;

@Controller
public class ProductController {
    
    ProductService productService;

    ProductController(ProductService ps){
        this.productService = ps;
    }


    @GetMapping("/products")
    public String getAllProducts(Model m){
        
        var products  = productService.findAll();

        m.addAttribute("products" , products);

        return "products.html";
        
        
    }

    @PostMapping("/products")
    public String addProduct(@RequestParam String name , @RequestParam Double price , Model m){


        Product product = new Product();

        product.setName(name);
        product.setPrice(price);

        productService.addProduct(product);
        
        return "products.html";
    }
}
