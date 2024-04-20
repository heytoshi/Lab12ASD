package edu.miu.cs489.tsogt.lab_12.repository;

import edu.miu.cs489.tsogt.lab_12.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurgeryRepository extends JpaRepository<Surgery, Integer> {
}
