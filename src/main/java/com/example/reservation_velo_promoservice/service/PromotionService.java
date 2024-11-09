package com.example.reservation_velo_promoservice.service;

import com.example.reservation_velo_promoservice.entity.Promotion;
import com.example.reservation_velo_promoservice.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;

    public List<Promotion> getAllPromotions() {
        return promotionRepository.findAll();
    }

    public Promotion getPromotionById(Long id) {
        return promotionRepository.findById(id).orElse(null);
    }

    public Promotion createPromotion(Promotion promotion) {
        return promotionRepository.save(promotion);
    }

    public Promotion updatePromotion(Long id, Promotion promotionDetails) {
        Optional<Promotion> promotionOptional = promotionRepository.findById(id);

        if (promotionOptional.isPresent()) {
            Promotion promotion = promotionOptional.get();
            promotion.setName(promotionDetails.getName());
            promotion.setDescription(promotionDetails.getDescription());
            promotion.setDiscountPercentage(promotionDetails.getDiscountPercentage());
            promotion.setStartDate(promotionDetails.getStartDate());
            promotion.setEndDate(promotionDetails.getEndDate());
            promotion.setIsActive(promotionDetails.getIsActive());
            return promotionRepository.save(promotion);
        }

        return null;
    }

    public void deletePromotion(Long id) {
        promotionRepository.deleteById(id);
    }
}
