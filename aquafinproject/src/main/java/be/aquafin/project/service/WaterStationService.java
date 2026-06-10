package be.aquafin.project.service;

import be.aquafin.project.model.WaterStation;
import be.aquafin.project.repository.WaterStationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaterStationService {

    private final WaterStationRepository waterStationRepository;

    public WaterStationService(WaterStationRepository waterStationRepository) {
        this.waterStationRepository = waterStationRepository;
    }

    public List<WaterStation> getAllStations() {
        return waterStationRepository.findAll();
    }

    public WaterStation saveStation(WaterStation station) {
        return waterStationRepository.save(station);
    }
}