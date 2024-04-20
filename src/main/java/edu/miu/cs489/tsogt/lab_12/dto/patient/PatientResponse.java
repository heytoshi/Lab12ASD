package edu.miu.cs489.tsogt.lab_12.dto.patient;

import edu.miu.cs489.tsogt.lab_12.model.Address;

public record PatientResponse(
        int id,
        String firstName,
        String lastName,
        String contactPhoneNumber,
        String email,
        String dateOfBirth,
        Address address
) {
}