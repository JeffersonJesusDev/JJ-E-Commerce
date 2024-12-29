package com.jjdev.JJE_commerce.resources;

import com.jjdev.JJE_commerce.entities.Product;
import com.jjdev.JJE_commerce.repositories.ProductRepository;
import com.jjdev.JJE_commerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllCategories() {
        List<Product> cat = productService.findAll();
        return ResponseEntity.ok().body(cat);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findProductBId(@PathVariable Long id) {
        Product obj = productService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
