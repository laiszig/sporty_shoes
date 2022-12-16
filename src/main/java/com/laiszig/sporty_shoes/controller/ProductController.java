package com.laiszig.sporty_shoes.controller;

import com.laiszig.sporty_shoes.entity.Category;
import com.laiszig.sporty_shoes.entity.Product;
import com.laiszig.sporty_shoes.formData.ProductFormData;
import com.laiszig.sporty_shoes.service.CategoryService;
import com.laiszig.sporty_shoes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/admin/product")
    public String listAll(Model model) {
        model.addAttribute("products", productService.getAll());
        return "adminProduct";
    }

    @GetMapping("/admin/product/create")
    public String create(Model model) {
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        model.addAttribute("product", new ProductFormData());
        return "adminCreateProduct";
    }

    @PostMapping("/admin/product/create")
    public String addProduct(ProductFormData formData, RedirectAttributes redirectAttributes) {
        Category category = categoryService.findById(formData.getCategoryId()).orElse(null);
        Product product = new Product();
        product.setName(formData.getName());
        product.setPrice(formData.getPrice());
        product.setCategory(category);
        productService.saveProduct(product);
        redirectAttributes.addFlashAttribute("message", "added");
        return "redirect:/admin/product";
    }
}
