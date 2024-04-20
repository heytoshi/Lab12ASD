package edu.miu.cs489.tsogt.lab_12.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Appointment")
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Patient patient;
    @ManyToOne(cascade = CascadeType.ALL)
    private Dentist dentist;
    @ManyToOne(cascade = CascadeType.ALL)
    private Surgery surgery;

    private String appointmentDate;
    private Double appointmentTime;

    public Appointment(Patient patient, Dentist dentist, Surgery surgery, String appointmentDate, Double appointmentTime) {
        this.patient = patient;
        this.dentist = dentist;
        this.surgery = surgery;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
    }
}
