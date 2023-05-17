package main.java.org.webproject.interfaces;

import main.java.org.webproject.models.Appointment;

import java.util.List;

public interface AppointmentInterface {
    void createAppointment(Appointment appointment);
    List<Appointment> getAllAppointments();
    Appointment getAppointmentById(Long id);
    void updateAppointment(Appointment appointment);
    void deleteAppointment(Long id);
    void closeConnection();
}

