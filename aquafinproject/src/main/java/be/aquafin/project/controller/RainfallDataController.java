package be.aquafin.project.controller;

import be.aquafin.project.model.RainfallData;
import be.aquafin.project.service.RainfallDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RainfallDataController {

    private final RainfallDataService rainfallDataService;

    public RainfallDataController(RainfallDataService rainfallDataService) {
        this.rainfallDataService = rainfallDataService;
    }

    @GetMapping("/rainfall")
    public List<RainfallData> getAllRainfallData() {
        return rainfallDataService.getAllRainfallData();
    }
}