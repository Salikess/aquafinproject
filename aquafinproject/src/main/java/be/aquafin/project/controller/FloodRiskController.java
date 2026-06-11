package be.aquafin.project.controller;
import be.aquafin.project.model.FloodRiskForecast;
import java.util.List;
import be.aquafin.project.service.FloodRiskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FloodRiskController {

    private final FloodRiskService floodRiskService;

    public FloodRiskController(FloodRiskService floodRiskService) {
        this.floodRiskService = floodRiskService;
    }

    @GetMapping("/flood-risk")
    public String getFloodRisk() {
        return floodRiskService.calculateLatestWinterRisk();
    }

    @GetMapping("/flood-risk/prediction")
    public double getWinterPrediction() {
        return floodRiskService.predictNextWinterRainfall();
    }
    @GetMapping("/flood-risk/forecast")
    public List<FloodRiskForecast> getFiveYearForecast() {
        return floodRiskService.predictNextFiveYears();
    }
}