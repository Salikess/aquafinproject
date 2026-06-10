package be.aquafin.project.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class RainfallData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rainfall_year")
    private int year;
    private double winterRain;
    private double springRain;
    private double summerRain;
    private double autumnRain;

    public RainfallData() {
    }

    public RainfallData(int year, double winterRain, double springRain,
                        double summerRain, double autumnRain) {
        this.year = year;
        this.winterRain = winterRain;
        this.springRain = springRain;
        this.summerRain = summerRain;
        this.autumnRain = autumnRain;
    }

    public Long getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getWinterRain() {
        return winterRain;
    }

    public void setWinterRain(double winterRain) {
        this.winterRain = winterRain;
    }

    public double getSpringRain() {
        return springRain;
    }

    public void setSpringRain(double springRain) {
        this.springRain = springRain;
    }

    public double getSummerRain() {
        return summerRain;
    }

    public void setSummerRain(double summerRain) {
        this.summerRain = summerRain;
    }

    public double getAutumnRain() {
        return autumnRain;
    }

    public void setAutumnRain(double autumnRain) {
        this.autumnRain = autumnRain;
    }
}