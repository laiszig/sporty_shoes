package com.laiszig.sporty_shoes.repository;

import com.laiszig.sporty_shoes.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
