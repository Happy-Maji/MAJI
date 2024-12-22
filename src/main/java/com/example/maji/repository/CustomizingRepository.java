package com.example.maji.repository;

import com.example.maji.entity.CustomizingEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomizingRepository extends JpaRepository<CustomizingEntity, Long> {

    @Query("SELECT c FROM CustomizingEntity c ORDER BY c.customizingIdx DESC")
    List<CustomizingEntity> findAllWithPagination();

    Page<CustomizingEntity> findAllByOrderByCustomizingIdxDesc(Pageable pageable);

}
