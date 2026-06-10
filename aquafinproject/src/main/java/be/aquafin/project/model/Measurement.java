package be.aquafin.project.model;

import jakarta.persistence.*;

@Entity
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double measurementValue;
    private String date;

    @ManyToOne
    private Sensor sensor;

    public Measurement() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getMeasurementValue() {
        return measurementValue;
    }

    public void setMeasurementValue(double measurementValue) {
        this.measurementValue = measurementValue;
    }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public Sensor getSensor() { return sensor; }
    public void setSensor(Sensor sensor) { this.sensor = sensor; }
}