package tn.esprit.StationVelo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.StationVelo.entity.Station;

// Repository pour StationVelo
@Repository
public interface StationRepo extends JpaRepository<Station, Long> {}

