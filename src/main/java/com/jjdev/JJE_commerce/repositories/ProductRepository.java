package com.jjdev.JJE_commerce.repositories;

import com.jjdev.JJE_commerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
