package edu.miu.cs489.tsogt.lab_12.service.impl;

import edu.miu.cs489.tsogt.lab_12.model.Appointment;
import edu.miu.cs489.tsogt.lab_12.repository.AppointmentRepository;
import edu.miu.cs489.tsogt.lab_12.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<Appointment> getAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment addAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment updateAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointment(Appointment appointment) {
        this.appointmentRepository.delete(appointment);
    }

    @Override
    public Appointment getAppointment(int id) {
        return appointmentRepository.findById(id).orElse(null);
    }
}
