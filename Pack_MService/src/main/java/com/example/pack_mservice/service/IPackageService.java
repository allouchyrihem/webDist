package com.example.pack_mservice.service;

import com.example.pack_mservice.entity.Activity;
import com.example.pack_mservice.entity.Pack;

import java.util.List;

public interface IPackageService {
    List<Pack> getAllPackages();
    Pack addPack(Pack p);
    Pack updatePack(Pack p);
    List<Pack> findPacksByPriceAndDuration(String minPrice, String maxPrice, String minDuration, String maxDuration);
    void deletePack(Long id);
    List<Activity> getAllActivities();
    Activity addActivity(Activity a);
    Activity updateActivity(Activity p);
    void deleteActivity(Long id);

    // Advanced Service Methods
    List<Pack> findPacksByActivityId(Long activityId);
    Pack addActivityToPack(Long packId, Long activityId);
    Activity getActById(Long idAct);
    Pack getPackById(Long idPack);
    List<Pack> getPacksWithActivityDetails();
}
