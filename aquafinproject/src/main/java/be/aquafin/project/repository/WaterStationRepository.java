package be.aquafin.project.repository;

import be.aquafin.project.model.WaterStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaterStationRepository extends JpaRepository<WaterStation, Long> {

}