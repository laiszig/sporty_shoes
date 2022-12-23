package com.laiszig.sporty_shoes.repository;

import com.laiszig.sporty_shoes.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
}
