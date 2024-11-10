package com.example.pack_mservice.repository;

import com.example.pack_mservice.entity.Pack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface packRepository extends JpaRepository<Pack, Long> {
    List<Pack> findByPrixBetweenAndDureeBetween(String minPrice, String maxPrice, String minDuration, String maxDuration);
    @Query("SELECT p FROM Pack p JOIN p.activities a WHERE a.activityId = :activityId")
    List<Pack> findByActivitiesActivityId(@Param("activityId") Long activityId);

}
