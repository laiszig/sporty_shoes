package com.laiszig.sporty_shoes.service;

import com.laiszig.sporty_shoes.entity.Purchase;
import com.laiszig.sporty_shoes.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;

    public Purchase save(Purchase purchase){
        return purchaseRepository.save(purchase);
    }
}
