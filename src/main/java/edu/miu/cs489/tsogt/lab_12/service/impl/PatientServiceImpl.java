package edu.miu.cs489.tsogt.lab_12.service.impl;

import edu.miu.cs489.tsogt.lab_12.dto.patient.PatientRequest;
import edu.miu.cs489.tsogt.lab_12.dto.patient.PatientResponse;
import edu.miu.cs489.tsogt.lab_12.exception.PatientNotFoundException;
import edu.miu.cs489.tsogt.lab_12.model.Patient;
import edu.miu.cs489.tsogt.lab_12.repository.AddressRepository;
import edu.miu.cs489.tsogt.lab_12.repository.PatientRepository;
import edu.miu.cs489.tsogt.lab_12.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    private final AddressRepository addressRepository;
    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository, AddressRepository addressRepository) {
        this.patientRepository = patientRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public List<PatientResponse> getPatients() {
        return patientRepository.findAll().stream()
                .map(p -> new PatientResponse(
                        p.getId(),
                        p.getFirstName(),
                        p.getLastName(),
                        p.getContactPhoneNumber(),
                        p.getEmail(),
                        p.getDateOfBirth(),
                        p.getAddress()
                )).toList();
    }

    @Override
    public PatientResponse getPatient(Integer id) throws PatientNotFoundException {
        Optional<Patient> patientOptional = patientRepository.findById(id);

        if (patientOptional.isPresent()) {
            Patient patient = patientOptional.get();
            return new PatientResponse(
                    patient.getId(),
                    patient.getFirstName(),
                    patient.getLastName(),
                    patient.getContactPhoneNumber(),
                    patient.getEmail(),
                    patient.getDateOfBirth(),
                    patient.getAddress()
            );
        } else {
            throw new PatientNotFoundException(String.format("Error: Patient with ID %d is not found", id));
        }
    }


    @Override
    public PatientResponse addPatient(PatientRequest patient) {
        var newPatient = new Patient(
                patient.firstName(),
                patient.lastName(),
                patient.contactPhoneNumber(),
                patient.email(),
                patient.dateOfBirth(),
                null,
                patient.address());
        var savedPatient = patientRepository.save(newPatient);
        return new PatientResponse(
                savedPatient.getId(),
                savedPatient.getFirstName(),
                savedPatient.getLastName(),
                savedPatient.getContactPhoneNumber(),
                savedPatient.getEmail(),
                savedPatient.getDateOfBirth(),
                savedPatient.getAddress()
        );
    }

    @Override
    public PatientResponse updatePatient(Integer id, PatientRequest patientRequest) throws PatientNotFoundException {
        var patient = patientRepository.findById(id).orElse(null);
        if (patient != null) {
            patient.setFirstName(patientRequest.firstName());
            patient.setLastName(patientRequest.lastName());
            patient.setContactPhoneNumber(patientRequest.contactPhoneNumber());
            patient.setEmail(patientRequest.email());
            patient.setDateOfBirth(patientRequest.dateOfBirth());
            patient.setAddress(patientRequest.address());
            if (patient.getAddress() != null) {
                var oldAddress = patient.getAddress();
                oldAddress.setStreetAddress(patientRequest.address().getStreetAddress());
                oldAddress.setCity(patientRequest.address().getCity());
                oldAddress.setState(patientRequest.address().getState());
                oldAddress.setPostalCode(patientRequest.address().getPostalCode());
            } else {
                patient.setAddress(patientRequest.address());
            }
            patientRepository.save(patient);
            return new PatientResponse(
                    patient.getId(),
                    patient.getFirstName(),
                    patient.getLastName(),
                    patient.getContactPhoneNumber(),
                    patient.getEmail(),
                    patient.getDateOfBirth(),
                    patient.getAddress()
            );
        } else {
            throw new PatientNotFoundException(String.format("Error: Patient with ID %d is not found", id));
        }
    }

    @Override
    public void deletePatient(Integer id) {
        patientRepository.deleteById(id);
    }

    @Override
    public List<PatientResponse> searchPatients(String searchString) {
        List<Patient> patients = patientRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrContactPhoneNumberContainingOrAddressStreetAddressContainingIgnoreCaseOrAddressCityContainingIgnoreCaseOrAddressStateContainingIgnoreCaseOrAddressPostalCodeContaining(
                searchString, searchString, searchString, searchString, searchString, searchString, searchString, searchString);


        return patients.stream()
                .map(p -> new PatientResponse(
                        p.getId(),
                        p.getFirstName(),
                        p.getLastName(),
                        p.getContactPhoneNumber(),
                        p.getEmail(),
                        p.getDateOfBirth(),
                        p.getAddress()
                )).toList();
    }
}
