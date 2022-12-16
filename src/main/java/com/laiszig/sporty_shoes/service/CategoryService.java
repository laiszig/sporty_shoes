package com.laiszig.sporty_shoes.service;

import com.laiszig.sporty_shoes.entity.Category;
import com.laiszig.sporty_shoes.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll () {
        return categoryRepository.findAll();
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Optional<Category> findById(Integer id) {
        return categoryRepository.findById(id);
    }
}
