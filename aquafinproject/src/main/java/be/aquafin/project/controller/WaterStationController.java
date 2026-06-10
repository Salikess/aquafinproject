package be.aquafin.project.controller;

import be.aquafin.project.model.WaterStation;
import be.aquafin.project.service.WaterStationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stations")
public class WaterStationController {

    private final WaterStationService waterStationService;

    public WaterStationController(WaterStationService waterStationService) {
        this.waterStationService = waterStationService;
    }

    @GetMapping
    public List<WaterStation> getAllStations() {
        return waterStationService.getAllStations();
    }

    @PostMapping
    public WaterStation createStation(@RequestBody WaterStation station) {
        return waterStationService.saveStation(station);
    }
}