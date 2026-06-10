package be.aquafin.project.repository;

import be.aquafin.project.model.RainfallData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RainfallDataRepository extends JpaRepository<RainfallData, Long> {
}