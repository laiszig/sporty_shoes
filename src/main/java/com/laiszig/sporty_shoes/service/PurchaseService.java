package com.laiszig.sporty_shoes.service;

import com.laiszig.sporty_shoes.entity.Purchase;
import com.laiszig.sporty_shoes.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;

    public Purchase save(Purchase purchase){
        return purchaseRepository.save(purchase);
    }

    public List<Purchase> getAll() {
        return purchaseRepository.findAll();
    }

    public List<Purchase> search(Integer categoryId, LocalDate date) {
        return purchaseRepository.findAllByCategoryIdAndDate(categoryId, date);
    }
}
