package edu.miu.cs489.tsogt.lab_12.repository;


import edu.miu.cs489.tsogt.lab_12.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

    List<Patient> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrContactPhoneNumberContainingOrAddressStreetAddressContainingIgnoreCaseOrAddressCityContainingIgnoreCaseOrAddressStateContainingIgnoreCaseOrAddressPostalCodeContaining(String searchString, String searchString1, String searchString2, String searchString3, String searchString4, String searchString5, String searchString6, String searchString7);
}
