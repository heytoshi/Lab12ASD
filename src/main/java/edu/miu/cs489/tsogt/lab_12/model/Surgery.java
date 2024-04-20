package edu.miu.cs489.tsogt.lab_12.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Surgery")
public class Surgery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String telephoneNumber;

    @OneToMany(mappedBy = "surgery", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public Surgery(String name, String telephoneNumber, List<Appointment> appointments, Address address) {
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.appointments = appointments;
        this.address = address;
    }
}
