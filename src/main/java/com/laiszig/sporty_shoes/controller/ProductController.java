package com.laiszig.sporty_shoes.controller;

import com.laiszig.sporty_shoes.entity.Category;
import com.laiszig.sporty_shoes.entity.Product;
import com.laiszig.sporty_shoes.entity.Purchase;
import com.laiszig.sporty_shoes.formData.ProductFormData;
import com.laiszig.sporty_shoes.formData.PurchaseFormData;
import com.laiszig.sporty_shoes.service.CategoryService;
import com.laiszig.sporty_shoes.service.ProductService;
import com.laiszig.sporty_shoes.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private PurchaseService purchaseService;

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

    @GetMapping("/store/products")
    public String storeListAll(Model model) {
        model.addAttribute("products", productService.getAll());
        return "storeProductList";
    }

    @GetMapping("/store/products/{id}")
    public String detail(Model model, @PathVariable Integer id) {
        model.addAttribute("product", productService.getById(id).get()); //TODO: VAI DAR PROBLEMA
        model.addAttribute("purchase", new PurchaseFormData());
        return "productDetail";
    }

    @PostMapping("/store/products/{id}")
    public String purchase(PurchaseFormData formData, RedirectAttributes redirectAttributes) {
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        Purchase purchase = new Purchase();
        Optional<Product> product = productService.getById(formData.getId());
        purchase.setQuantity(formData.getQuantity());
        purchase.setProductId(formData.getId());
        purchase.setUnitPrice(product.get().getPrice());
        purchase.setUsername(currentUser.getName());
        purchase.setTotalPrice(purchase.getUnitPrice().multiply(BigDecimal.valueOf(purchase.getQuantity())));
        purchase.setDate(LocalDate.now());
        purchase.setCategory(product.get().getCategory());
        purchaseService.save(purchase);
        return "redirect:/store/products";
    }
}
