package com.example.maji.repository;

import com.example.maji.entity.ShoppingHistoryEntity;
import com.example.maji.entity.ShoppingHistoryListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingHistoryListRepository extends JpaRepository<ShoppingHistoryListEntity, Long> {
}
