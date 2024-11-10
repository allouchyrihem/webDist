package tn.esprit.StationVelo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.StationVelo.entity.Station;
import tn.esprit.StationVelo.services.StationServ;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stations")
@CrossOrigin(origins = "http://localhost:4200")
public class StationController {
    @Autowired
    private StationServ stationVeloService;
    @GetMapping("/hello")
    public String hellotest() {
        return "hiiii";
    }

    @GetMapping("/all")
    public List<Station> getAllStations() {
        return stationVeloService.getAllStations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Station> getStationById(@PathVariable Long id) {
        Optional<Station> stationVelo = stationVeloService.getStationById(id);
        return stationVelo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Station createStation(@RequestBody Station stationVelo) {
        return stationVeloService.addStation(stationVelo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Station> updateStation(@PathVariable Long id, @RequestBody Station stationVelo) {
        return ResponseEntity.ok(stationVeloService.updateStation(id, stationVelo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStation(@PathVariable Long id) {
        stationVeloService.deleteStation(id);
        return ResponseEntity.noContent().build();
    }
}