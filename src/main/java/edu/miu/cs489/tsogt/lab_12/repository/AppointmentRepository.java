package edu.miu.cs489.tsogt.lab_12.repository;

import edu.miu.cs489.tsogt.lab_12.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}
