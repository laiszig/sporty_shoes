package com.laiszig.sporty_shoes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController{

    @GetMapping("/admin/category")
    public String listAll(Model model) {
        return "adminCategory";
    }
}
