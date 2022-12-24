package com.laiszig.sporty_shoes.repository;

import com.laiszig.sporty_shoes.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

    List<Purchase> findAllByCategoryIdAndDate(Integer categoryId, LocalDate date);

}
