package com.laiszig.sporty_shoes.controller;

import com.laiszig.sporty_shoes.entity.Category;
import com.laiszig.sporty_shoes.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CategoryController{

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/admin/category")
   // @PreAuthorize("hasRole('ADMIN')")
  //  @Secured({"ADMIN"})
    public String listAll(Model model) {
        model.addAttribute("categories", categoryService.getAll());
        return "adminCategory";
    }

    @GetMapping("/admin/category/create")
    public String create(Model model) {
        model.addAttribute("category", new Category());
        return "adminCreateCategory";
    }

    @PostMapping("/admin/category/create")
    public String addCategory(Category category, RedirectAttributes redirectAttributes) {
        categoryService.saveCategory(category);
        redirectAttributes.addFlashAttribute("message", "added");
        return "redirect:/admin/category";
    }
}
