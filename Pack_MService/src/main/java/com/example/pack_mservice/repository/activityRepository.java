package com.example.pack_mservice.repository;

import com.example.pack_mservice.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface activityRepository extends JpaRepository<Activity, Long> {
}
