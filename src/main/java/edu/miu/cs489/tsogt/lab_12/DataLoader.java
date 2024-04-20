package edu.miu.cs489.tsogt.lab_12;
import edu.miu.cs489.tsogt.lab_12.model.*;
import edu.miu.cs489.tsogt.lab_12.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    private final DentistRepository dentistRepository;
    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;
    private final SurgeryRepository surgeryRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public DataLoader(DentistRepository dentistRepository,
                      PatientRepository patientRepository,
                      AppointmentRepository appointmentRepository,
                      SurgeryRepository surgeryRepository,
                      AddressRepository addressRepository) {
        this.dentistRepository = dentistRepository;
        this.patientRepository = patientRepository;
        this.appointmentRepository = appointmentRepository;
        this.surgeryRepository = surgeryRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Address address1 = new Address("123 Main St", "New York", "NY", "10001");
        Address address2 = new Address("456 Park Ave", "Los Angeles", "CA", "90001");
        Address address3 = new Address("789 Broadway", "Chicago", "IL", "60601");
        Address address4 = new Address("101 Elm St", "Houston", "TX", "77001");
        Address address5 = new Address("202 Cedar Ln", "Phoenix", "AZ", "85001");
        Address address6 = new Address("303 Pine Rd", "Philadelphia", "PA", "19101");
        Address address7 = new Address("404 Willow Ave", "San Antonio", "TX", "78201");

        Dentist dentist1 = new Dentist("Tony", "Smith", "123-456-7890", "tony.smith@gmail.com", "Spec1", null);
        Dentist dentist2 = new Dentist("Helen", "Pearson", "123-123-7890", "helen.pearson@gmail.com", "Spec2", null);
        Dentist dentist3 = new Dentist("Robin", "Plevin", "123-789-7810", "robin.plevin@gmail.com", "Spec3", null);

        Patient patient1 = new Patient("Gillian", "White", "987-654-3210", "gillian.white@gmail.com", "01-Sep-1999", null, address1);
        Patient patient2 = new Patient("Jill", "Bell", "431-231-5412", "jill.bell@gmail.com", "01-Oct-1999", null, address2);
        Patient patient3 = new Patient("Ian", "MackKay", "902-231-5412", "ian.bmackey@gmail.com", "01-Oct-1999", null, address3);
        Patient patient4 = new Patient("John", "Walker", "202-431-5412", "john.walker@gmail.com", "01-Oct-1989", null, address4);

        Surgery surgery1 = new Surgery("Clinic One", "432-231-6809", null, address5);
        Surgery surgery2 = new Surgery("Clinic Two", "432-231-6129", null, address6);
        Surgery surgery3 = new Surgery("Clinic Three", "432-231-6309", null, address7);

        List<Appointment> appointments = Arrays.asList(
                new Appointment(patient1, dentist1, surgery1, "12-Sep-13", 10.00),
                new Appointment(patient2, dentist1, surgery1, "12-Sep-13", 12.00),
                new Appointment(patient3, dentist2, surgery2, "12-Sep-13", 10.00),
                new Appointment(patient3, dentist2, surgery2, "14-Sep-13", 14.00),
                new Appointment(patient2, dentist3, surgery1, "14-Sep-13", 16.30),
                new Appointment(patient4, dentist3, surgery3, "15-Sep-13", 18.00)
        );

        appointmentRepository.saveAll(appointments);
        patientRepository.saveAll(Arrays.asList(patient1, patient2, patient3, patient4));
        dentistRepository.saveAll(Arrays.asList(dentist1, dentist2, dentist3));
        surgeryRepository.saveAll(Arrays.asList(surgery1, surgery2, surgery3));

    }
}



