package com.laiszig.sporty_shoes.controller;

import com.laiszig.sporty_shoes.entity.Product;
import com.laiszig.sporty_shoes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/admin/product")
    public String listAll(Model model) {
        model.addAttribute("products", productService.getAll());
        return "adminProduct";
    }

    @GetMapping("/admin/product/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "adminCreateProduct";
    }

    @PostMapping("/admin/product/create")
    public String addProduct(Product product, RedirectAttributes redirectAttributes) {
        productService.saveProduct(product);
        redirectAttributes.addFlashAttribute("message", "added");
        return "redirect:/admin/product";
    }
}
