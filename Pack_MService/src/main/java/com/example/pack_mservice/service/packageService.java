package com.example.pack_mservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.example.pack_mservice.entity.*;
import com.example.pack_mservice.repository.activityRepository;
import com.example.pack_mservice.repository.packRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class packageService implements IPackageService {

    @Autowired
    packRepository packRepo;

    @Autowired
    activityRepository activityRepo;

    @Override
    public List<Pack> getAllPackages() {
        return packRepo.findAll();
    }

    @Override
    public Pack addPack(Pack p) {
        return packRepo.save(p);
    }

    @Override
    public Pack updatePack(Pack p) {
        return packRepo.save(p);
    }

    @Override
    public List<Pack> findPacksByPriceAndDuration(String minPrice, String maxPrice, String minDuration, String maxDuration) {
        return packRepo.findByPrixBetweenAndDureeBetween(minPrice, maxPrice, minDuration, maxDuration);
    }

    @Override
    public void deletePack(Long id) {
        packRepo.deleteById(id);
    }

    @Override
    public List<Activity> getAllActivities() {
        return activityRepo.findAll();
    }

    @Override
    public Activity addActivity(Activity a) {
        return activityRepo.save(a);
    }

    @Override
    public Activity updateActivity(Activity a) {
        return activityRepo.save(a);
    }

    @Override
    public void deleteActivity(Long id) {
        activityRepo.deleteById(id);
    }

    // Advanced Service Methods

    // 1. Find Packs by Activity ID
    @Override
    public List<Pack> findPacksByActivityId(Long activityId) {
        List<Pack> packs = packRepo.findByActivitiesActivityId(activityId);
        if (packs.isEmpty()) {
            log.warn("No packs found for Activity with ID: {}", activityId);
        }
        return packs;
    }

    // 2. Add an Activity to a Pack
    @Override
    public Pack addActivityToPack(Long packId, Long activityId) {
        Pack pack = packRepo.findById(packId)
                .orElseThrow(() -> new RuntimeException("Pack not found with ID: " + packId));

        Activity activity = activityRepo.findById(activityId)
                .orElseThrow(() -> new RuntimeException("Activity not found with ID: " + activityId));

        pack.getActivities().add(activity);  // Add activity to the pack
        activity.getPacks().add(pack);       // Add pack to the activity

        packRepo.save(pack);  // Save the updated pack
        activityRepo.save(activity);  // Save the updated activity

        log.info("Activity with ID: {} added to Pack with ID: {}", activityId, packId);
        return pack;
    }

    @Override
    public Activity getActById(Long idAct) {
        return activityRepo.findById(idAct).orElse(null);
    }

    @Override
    public Pack getPackById(Long idPack) {
        return packRepo.findById(idPack).orElse(null);
    }

    // 3. Get Packs with Detailed Activities
    @Override
    public List<Pack> getPacksWithActivityDetails() {
        List<Pack> packs = packRepo.findAll();
        for (Pack pack : packs) {
            Set<Activity> activities = pack.getActivities();
            for (Activity activity : activities) {
                log.info("Pack ID: {} includes Activity: {} with details: {}",
                        pack.getPackId(), activity.getActivityId(), activity.getDetail());
            }
        }
        return packs;
    }
}
