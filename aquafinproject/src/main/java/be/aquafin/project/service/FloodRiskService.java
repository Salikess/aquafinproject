package be.aquafin.project.service;
import be.aquafin.project.model.FloodRiskForecast;
import java.util.ArrayList;
import be.aquafin.project.model.RainfallData;
import be.aquafin.project.repository.RainfallDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloodRiskService {

    private final RainfallDataRepository rainfallDataRepository;

    public FloodRiskService(RainfallDataRepository rainfallDataRepository) {
        this.rainfallDataRepository = rainfallDataRepository;
    }

    public String calculateRisk(double rainfall, double threshold) {
        if (rainfall > threshold) {
            return "HIGH RISK";
        }
        return "LOW RISK";
    }

    public String calculateWinterRisk(double rainfall) {
        return calculateRisk(rainfall, 300);
    }

    public String calculateSpringRisk(double rainfall) {
        return calculateRisk(rainfall, 250);
    }

    public String calculateSummerRisk(double rainfall) {
        return calculateRisk(rainfall, 260);
    }

    public String calculateAutumnRisk(double rainfall) {
        return calculateRisk(rainfall, 280);
    }

    public List<RainfallData> getRainfallDataFromDatabase() {
        return rainfallDataRepository.findAll();
    }

    public String calculateLatestWinterRisk() {

        List<RainfallData> data = rainfallDataRepository.findAll();

        if (data.isEmpty()) {
            return "NO DATA";
        }

        RainfallData latest = data.get(data.size() - 1);

        return calculateWinterRisk(latest.getWinterRain());
    }

    public double predictNextWinterRainfall() {

        List<RainfallData> data = rainfallDataRepository.findAll();

        if (data.size() < 2) {
            return 0;
        }

        RainfallData previous = data.get(data.size() - 2);
        RainfallData latest = data.get(data.size() - 1);

        return (previous.getWinterRain() + latest.getWinterRain()) / 2;
    }

    public List<FloodRiskForecast> predictNextFiveYears() {

        List<RainfallData> data = rainfallDataRepository.findAll();

        List<FloodRiskForecast> forecasts = new ArrayList<>();

        if (data.size() < 2) {
            return forecasts;
        }

        RainfallData previous = data.get(data.size() - 2);
        RainfallData latest = data.get(data.size() - 1);

        double prediction =
                (previous.getWinterRain() + latest.getWinterRain()) / 2;

        int currentYear = latest.getYear();

        for (int i = 1; i <= 5; i++) {

            String risk = calculateWinterRisk(prediction);

            forecasts.add(
                    new FloodRiskForecast(
                            currentYear + i,
                            prediction,
                            risk
                    )
            );
        }

        return forecasts;
    }
}