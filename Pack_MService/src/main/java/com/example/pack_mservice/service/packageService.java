package com.example.pack_mservice.service;

import jakarta.transaction.Transactional;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import com.example.pack_mservice.entity.*;
import com.example.pack_mservice.repository.activityRepository;
import com.example.pack_mservice.repository.packRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class packageService implements IPackageService{
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
        return packRepo.save(p);    }

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
    public List<Activity> getAllActitivities() {
        return activityRepo.findAll();
    }

    @Override
    public Activity addActivity(Activity a) {
        return activityRepo.save(a);
    }

    @Override
    public Activity updateActvity(Activity p) {
        return activityRepo.save(p);
    }

    @Override
    public void deleteActivity(Long id) {
        activityRepo.deleteById(id);
    }
}
