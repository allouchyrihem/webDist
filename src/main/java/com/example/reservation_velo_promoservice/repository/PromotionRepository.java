package com.example.reservation_velo_promoservice.repository;

import com.example.reservation_velo_promoservice.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    List<Promotion> findByIsActive(Boolean isActive);
}
