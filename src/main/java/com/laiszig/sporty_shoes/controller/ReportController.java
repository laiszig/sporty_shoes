package com.laiszig.sporty_shoes.controller;

import com.laiszig.sporty_shoes.entity.Purchase;
import com.laiszig.sporty_shoes.formData.SearchPurchaseFormData;
import com.laiszig.sporty_shoes.service.CategoryService;
import com.laiszig.sporty_shoes.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ReportController {

    @Autowired
    PurchaseService purchaseService;

    @Autowired
    CategoryService categoryService;

    @RequestMapping("/admin/report")
    public String getReport(SearchPurchaseFormData formData, Model model) {

        List<Purchase> purchases = new ArrayList<>();
        if(formData.getDate() != null && formData.getCategoryId() != null) {
            purchases = purchaseService.search(formData.getCategoryId(), formData.getDate());
        } else {
            purchases = purchaseService.getAll();
        }

        model.addAttribute("purchases", purchases);
        model.addAttribute("searchPurchase", new SearchPurchaseFormData());
        model.addAttribute("categories", categoryService.getAll());
        return "purchaseReport";
    }

}
