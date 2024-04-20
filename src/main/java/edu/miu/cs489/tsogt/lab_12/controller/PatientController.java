package edu.miu.cs489.tsogt.lab_12.controller;

import edu.miu.cs489.tsogt.lab_12.dto.patient.PatientRequest;
import edu.miu.cs489.tsogt.lab_12.dto.patient.PatientResponse;
import edu.miu.cs489.tsogt.lab_12.exception.PatientNotFoundException;
import edu.miu.cs489.tsogt.lab_12.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping(value = "adsweb/api/v1/patient/list")
    public ResponseEntity<List<PatientResponse>> listPatients() {
        List<PatientResponse> patients = patientService.getPatients();
        return ResponseEntity.ok(patients);
    }

    @GetMapping(value = "adsweb/api/v1/patient/{patientId}")
    public ResponseEntity<PatientResponse> patient(@PathVariable Integer patientId) throws PatientNotFoundException {
        return ResponseEntity.ok(patientService.getPatient(patientId));
    }

    @PostMapping(value = "adsweb/api/v1/patient/register")
    public ResponseEntity<PatientResponse> registerNewPatient(@RequestBody PatientRequest patientRequest) {
        return new ResponseEntity<>(patientService.addPatient(patientRequest), HttpStatus.CREATED);
    }

    @PutMapping(value = "adsweb/api/v1/patient/update/{patientId}")
    public ResponseEntity<PatientResponse> updatePatient(@PathVariable Integer patientId, @RequestBody PatientRequest patientRequest) throws PatientNotFoundException {
        return new ResponseEntity<>(patientService.updatePatient(patientId, patientRequest),
                HttpStatus.OK);
    }

    @DeleteMapping(value = "adsweb/api/v1/patient/delete/{patientId}")
    public ResponseEntity<Void> deletePatient(@PathVariable Integer patientId) {
        patientService.deletePatient(patientId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "adsweb/api/v1/patient/search/{searchString}")
    public ResponseEntity<List<PatientResponse>> searchPatients(@PathVariable String searchString) {
        List<PatientResponse> patients = patientService.searchPatients(searchString);
        return ResponseEntity.ok(patients);
    }
}
