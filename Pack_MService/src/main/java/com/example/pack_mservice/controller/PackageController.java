package com.example.pack_mservice.controller;

import com.example.pack_mservice.entity.*;
import com.example.pack_mservice.service.packageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/pack")
public class PackageController {

    @Autowired
    private packageService packService;

    @GetMapping("/hello")
    public String test() {
        return "hello";
    }

    // Endpoint pour récupérer tous les packs
    @GetMapping("/getAllPacks")
    public ResponseEntity<List<Pack>> getAllPackages() {
        List<Pack> packages = packService.getAllPackages();
        return ResponseEntity.ok(packages);
    }

    // Endpoint pour ajouter un nouveau pack
    @PostMapping("/addPack")
    public ResponseEntity<Pack> addPack(@RequestBody Pack pack) {
        Pack savedPack = packService.addPack(pack);
        return ResponseEntity.ok(savedPack);
    }

    // Endpoint pour mettre à jour un pack
    @PutMapping("update/{id}")
    public ResponseEntity<Pack> updatePack(@PathVariable Long id, @RequestBody Pack pack) {
        pack.setPackId(id);  // Assurez-vous que l'ID correspond à celui de l'URL
        Pack updatedPack = packService.updatePack(pack);
        return ResponseEntity.ok(updatedPack);
    }

    @GetMapping("actById/{id}")
    public ResponseEntity<Activity> getActByid(@PathVariable Long id) {
        return ResponseEntity.ok(packService.getActById(id));
    }
    @GetMapping("packById/{id}")
    public ResponseEntity<Pack> getPackByid(@PathVariable Long id) {
        return ResponseEntity.ok(packService.getPackById(id));
    }
    // Endpoint pour supprimer un pack
    @DeleteMapping("deletePack/{id}")
    public ResponseEntity<Void> deletePack(@PathVariable Long id) {
        packService.deletePack(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint pour rechercher des packs par prix et durée
    @GetMapping("/search")
    public ResponseEntity<List<Pack>> findPacksByPriceAndDuration(
            @RequestParam String minPrice,
            @RequestParam String maxPrice,
            @RequestParam String minDuration,
            @RequestParam String maxDuration) {

        List<Pack> packs = packService.findPacksByPriceAndDuration(minPrice, maxPrice, minDuration, maxDuration);

        if (packs.isEmpty()) {
            return ResponseEntity.noContent().build(); // Renvoie 204 si aucun pack n'est trouvé
        }

        return ResponseEntity.ok(packs); // Renvoie 200 avec la liste des packs
    }

    // Endpoint pour récupérer toutes les activités
    @GetMapping("/activities")
    public ResponseEntity<List<Activity>> getAllActivities() {
        List<Activity> activities = packService.getAllActivities();
        return ResponseEntity.ok(activities);
    }

    // Endpoint pour ajouter une nouvelle activité
    @PostMapping("/addActivity")
    public ResponseEntity<Activity> addActivity(@RequestBody Activity activity) {
        Activity savedActivity = packService.addActivity(activity);
        return ResponseEntity.ok(savedActivity);
    }

    // Endpoint pour mettre à jour une activité
    @PutMapping("/updateActivity/{id}")
    public ResponseEntity<Activity> updateActivity(@PathVariable Long id, @RequestBody Activity activity) {
        activity.setActivityId(id);  // Assurez-vous que l'ID correspond à celui de l'URL
        Activity updatedActivity = packService.updateActivity(activity);
        return ResponseEntity.ok(updatedActivity);
    }

    // Endpoint pour supprimer une activité
    @DeleteMapping("/deleteActivity/{id}")
    public ResponseEntity<Void> deleteActivity(@PathVariable Long id) {
        packService.deleteActivity(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint pour rechercher des packs par activité ID
    @GetMapping("/packsByActivity/{activityId}")
    public ResponseEntity<List<Pack>> findPacksByActivityId(@PathVariable Long activityId) {
        List<Pack> packs = packService.findPacksByActivityId(activityId);
        if (packs.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 if no packs are found
        }
        return ResponseEntity.ok(packs); // 200 with the list of packs
    }

    // Endpoint pour ajouter une activité à un pack
    @PostMapping("/addActivityToPack/{packId}/{activityId}")
    public ResponseEntity<Pack> addActivityToPack(@PathVariable Long packId, @PathVariable Long activityId) {
        Pack updatedPack = packService.addActivityToPack(packId, activityId);
        return ResponseEntity.ok(updatedPack);
    }

    // Endpoint pour récupérer tous les packs avec leurs activités détaillées
    @GetMapping("/packsWithActivities")
    public ResponseEntity<List<Pack>> getPacksWithActivityDetails() {
        List<Pack> packs = packService.getPacksWithActivityDetails();
        return ResponseEntity.ok(packs);
    }
}
