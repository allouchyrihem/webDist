package com.example.pack_mservice.repository;

import com.example.pack_mservice.entity.Pack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface packRepository extends JpaRepository<Pack, Long> {
    List<Pack> findByPrixBetweenAndDureeBetween(String minPrice, String maxPrice, String minDuration, String maxDuration);
}
