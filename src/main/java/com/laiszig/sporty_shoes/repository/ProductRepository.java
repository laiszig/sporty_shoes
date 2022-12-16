package com.laiszig.sporty_shoes.repository;

import com.laiszig.sporty_shoes.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
