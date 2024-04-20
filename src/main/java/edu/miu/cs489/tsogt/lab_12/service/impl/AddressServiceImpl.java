package edu.miu.cs489.tsogt.lab_12.service.impl;

import edu.miu.cs489.tsogt.lab_12.dto.address.AddressResponse;
import edu.miu.cs489.tsogt.lab_12.dto.patient.PatientResponse1;
import edu.miu.cs489.tsogt.lab_12.model.Address;
import edu.miu.cs489.tsogt.lab_12.model.Patient;
import edu.miu.cs489.tsogt.lab_12.repository.AddressRepository;
import edu.miu.cs489.tsogt.lab_12.repository.PatientRepository;
import edu.miu.cs489.tsogt.lab_12.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;
    private PatientRepository patientRepository;

    public AddressServiceImpl(AddressRepository addressRepository, PatientRepository patientRepository) {
        this.addressRepository = addressRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public List<AddressResponse> getAllAddressesWithPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(patient -> new AddressResponse(
                        patient.getAddress().getId(),
                        patient.getAddress().getStreetAddress(),
                        patient.getAddress().getCity(),
                        patient.getAddress().getState(),
                        patient.getAddress().getPostalCode(),
                        new PatientResponse1(
                                patient.getId(),
                                patient.getFirstName(),
                                patient.getLastName(),
                                patient.getContactPhoneNumber(),
                                patient.getEmail(),
                                patient.getDateOfBirth()
                        )
                ))
                .sorted(Comparator.comparing(AddressResponse::city))
                .collect(Collectors.toList());
    }
}
