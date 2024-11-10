package tn.esprit.StationVelo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.StationVelo.dao.StationRepo;
import tn.esprit.StationVelo.entity.Station;

import java.util.List;
import java.util.Optional;

@Service
public class StationServ {

    @Autowired
    private StationRepo stationRepository;

    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }

    public Optional<Station> getStationById(Long id) {
        return stationRepository.findById(id);
    }

    public Station addStation(Station stationVelo) {
        return stationRepository.save(stationVelo);
    }

    public Station updateStation(Long id, Station stationDetails) {
        Station stationVelo = stationRepository.findById(id).orElseThrow(() -> new RuntimeException("Station non trouvée"));
        stationVelo.setNom(stationDetails.getNom());
        stationVelo.setLocalisation(stationDetails.getLocalisation());
        stationVelo.setCapacite(stationDetails.getCapacite());
        return stationRepository.save(stationVelo);
    }

    public void deleteStation(Long id) {
        stationRepository.deleteById(id);
    }
}
