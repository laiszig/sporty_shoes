package com.laiszig.sporty_shoes.controller;

import com.laiszig.sporty_shoes.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController{

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/admin/category")
    public String listAll(Model model) {
        model.addAttribute("categories", categoryService.getAll());
        return "adminCategory";
    }
}
