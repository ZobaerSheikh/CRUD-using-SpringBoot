package com.example.springcrud.repository;

import com.example.springcrud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository <Product,Integer> {


    Product findByName(String name);
}
