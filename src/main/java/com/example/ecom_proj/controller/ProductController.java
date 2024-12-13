package com.example.ecom_proj.controller;

import com.example.ecom_proj.model.Product;
import com.example.ecom_proj.repo.ProductRepo;
import com.example.ecom_proj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;


    @GetMapping("/products")
    public List<Product> getAllProducts( ){

        return service.getAllProducts();
    }

    @Autowired
    private ProductRepo repo;
    @GetMapping("/test")
    public List<Product> testRepo() {
        return repo.findAll(); // Direct repository call
    }

    //return one product
    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable int id){
        return service.getProductById(id);

    }

}
