package com.laiszig.sporty_shoes.controller;

import com.laiszig.sporty_shoes.entity.User;
import com.laiszig.sporty_shoes.formData.ProductFormData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/user")
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "createUser";
    }

//    @PostMapping("/user")
//    public String addProduct(ProductFormData formData, RedirectAttributes redirectAttributes) {
//        Category category = categoryService.findById(formData.getCategoryId()).orElse(null);
//        Product product = new Product();
//        product.setName(formData.getName());
//        product.setPrice(formData.getPrice());
//        product.setCategory(category);
//        productService.saveProduct(product);
//        redirectAttributes.addFlashAttribute("message", "added");
//        return "redirect:/admin/product";
//    }
}
