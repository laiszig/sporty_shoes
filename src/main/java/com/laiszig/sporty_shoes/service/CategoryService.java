package com.laiszig.sporty_shoes.service;

import com.laiszig.sporty_shoes.entity.Category;
import com.laiszig.sporty_shoes.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll () {
        return categoryRepository.findAll();
    }
}
