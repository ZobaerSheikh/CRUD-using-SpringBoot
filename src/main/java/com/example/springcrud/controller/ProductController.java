package com.example.springcrud.controller;

import com.example.springcrud.entity.Product;
import com.example.springcrud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //Talk to the service class
public class ProductController {

    @Autowired
    private ProductService service;

    //working for Post methods (service)
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
      public List<Product> addProduct(@RequestBody List<Product> products){
        return service.saveProducts(products);
    }


    //working for Get methods (service)
    @GetMapping("Products")
    public List<Product> findAllProducts(){
        return service.getProducts();
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id){
        return service.getProductById(id);
    }

    @GetMapping("/product/{name}")
public Product findProductByName(@PathVariable String name){
        return service.getProductByName(name);
    }

     //working for Update methods (service)
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return service.updateProduct(product);
    }

    //working for Delete methods(from service class)
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        return service.deleteProduct(id);
    }

}





















