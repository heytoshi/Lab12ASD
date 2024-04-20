package edu.miu.cs489.tsogt.lab_12.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Dentist")
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String contactPhoneNumber;
    private String email;
    private String specialization;

    @OneToMany(mappedBy = "dentist", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    public Dentist(String firstName, String lastName, String contactPhoneNumber, String email, String specialization, List<Appointment> appointments) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactPhoneNumber = contactPhoneNumber;
        this.email = email;
        this.specialization = specialization;
        this.appointments = appointments;
    }
}
