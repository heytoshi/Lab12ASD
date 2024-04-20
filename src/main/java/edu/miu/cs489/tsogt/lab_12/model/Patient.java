package edu.miu.cs489.tsogt.lab_12.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String contactPhoneNumber;
    private String email;
    private String dateOfBirth;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Appointment> appointmentList;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public Patient(String firstName, String lastName, String contactPhoneNumber, String email, String dateOfBirth, List<Appointment> appointmentList, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactPhoneNumber = contactPhoneNumber;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.appointmentList = appointmentList;
        this.address = address;
    }
}