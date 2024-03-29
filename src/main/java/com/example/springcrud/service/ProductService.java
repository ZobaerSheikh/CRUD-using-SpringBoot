package com.example.springcrud.service;

import com.example.springcrud.entity.Product;
import com.example.springcrud.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;


    // Post Method
    public Product saveProduct(Product product){
      return  repo.save(product);
    }
    public List <Product> saveProducts(List<Product> products){
      return  repo.saveAll(products);
    }

    //Get Methods

    public List<Product> getProducts() {
        return repo.findAll();
    }
     public Product getProductById(int id){
        return repo.findById(id).orElse(null);
    }
    public Product getProductByName(String name){
        return repo.findByName(name);
    }

    //Delete Method
    public String deleteProduct(int id){
        repo.deleteById(id);
        return "product removed !! "+id;
    }


    //Put Method
    public Product updateProduct(Product product){
       Product exitingProduct = repo.findById(product.getId()).orElse(null);
       exitingProduct.setName(product.getName());
       exitingProduct.setQuantity(product.getQuantity());
       exitingProduct.setPrice(product.getPrice());
       return repo.save(exitingProduct);

    }


}
