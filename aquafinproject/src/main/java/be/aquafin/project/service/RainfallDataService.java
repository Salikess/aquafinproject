package be.aquafin.project.service;

import be.aquafin.project.model.RainfallData;
import be.aquafin.project.repository.RainfallDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RainfallDataService {

    private final RainfallDataRepository rainfallDataRepository;

    public RainfallDataService(RainfallDataRepository rainfallDataRepository) {
        this.rainfallDataRepository = rainfallDataRepository;
    }

    public List<RainfallData> getAllRainfallData() {
        return rainfallDataRepository.findAll();
    }

    public RainfallData saveRainfallData(RainfallData rainfallData) {
        return rainfallDataRepository.save(rainfallData);
    }
}