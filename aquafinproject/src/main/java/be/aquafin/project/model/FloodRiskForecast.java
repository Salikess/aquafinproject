package be.aquafin.project.model;

public class FloodRiskForecast {

    private int year;
    private double predictedRainfall;
    private String risk;

    public FloodRiskForecast(int year, double predictedRainfall, String risk) {
        this.year = year;
        this.predictedRainfall = predictedRainfall;
        this.risk = risk;
    }

    public int getYear() {
        return year;
    }

    public double getPredictedRainfall() {
        return predictedRainfall;
    }

    public String getRisk() {
        return risk;
    }
}