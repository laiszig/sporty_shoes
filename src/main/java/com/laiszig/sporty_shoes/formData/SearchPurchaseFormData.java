package com.laiszig.sporty_shoes.formData;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


public class SearchPurchaseFormData {

    private Integer categoryId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
