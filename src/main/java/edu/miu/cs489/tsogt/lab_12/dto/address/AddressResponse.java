package edu.miu.cs489.tsogt.lab_12.dto.address;

import edu.miu.cs489.tsogt.lab_12.dto.patient.PatientResponse1;

public record AddressResponse(
        int id,
        String streetAddress,
        String city,
        String state,
        String postalCod,
        PatientResponse1 patient
) {
}