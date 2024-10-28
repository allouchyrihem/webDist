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
    List<Activity> getAllActitivities();
    Activity addActivity(Activity a);
    Activity updateActvity(Activity p);
    void deleteActivity(Long id);
}
