package com.example.maji.repository;

import com.example.maji.entity.CustomizingEntity;
import com.example.maji.entity.ShoppingHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingHistoryRepository extends JpaRepository<ShoppingHistoryEntity, Long> {
}
