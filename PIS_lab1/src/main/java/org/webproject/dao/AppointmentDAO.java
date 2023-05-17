package main.java.org.webproject.dao;

import main.java.org.webproject.models.Appointment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {
    private Connection connection;

    public AppointmentDAO(Connection connection) {
        this.connection = connection;
    }

    public void createAppointment(Appointment appointment) {
        String query = "INSERT INTO appointments (id, customer_id, service_id, employee_id, start_time, end_time, status) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, appointment.getId());
            statement.setLong(2, appointment.getCustomerId());
            statement.setLong(3, appointment.getServiceId());
            statement.setLong(4, appointment.getEmployeeId());
            statement.setObject(5, appointment.getStartTime());
            statement.setObject(6, appointment.getEndTime());
            statement.setString(7, appointment.getStatus().name().toLowerCase());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Appointment> getAllAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        String query = "SELECT * FROM appointments";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                Long customerId = resultSet.getLong("customer_id");
                Long serviceId = resultSet.getLong("service_id");
                Long employeeId = resultSet.getLong("employee_id");
                LocalDateTime startTime = resultSet.getObject("start_time", LocalDateTime.class);
                LocalDateTime endTime = resultSet.getObject("end_time", LocalDateTime.class);
                Appointment.AppointmentStatus status = Appointment.AppointmentStatus.valueOf(resultSet.getString("status"));
                Appointment appointment = new Appointment(id, customerId, serviceId, employeeId, startTime, endTime, status);
                appointments.add(appointment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }

    public Appointment getAppointmentById(Long id) {
        Appointment appointment = null;
        String query = "SELECT * FROM appointments WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Long customerId = resultSet.getLong("customer_id");
                    Long serviceId = resultSet.getLong("service_id");
                    Long employeeId = resultSet.getLong("employee_id");
                    LocalDateTime startTime = resultSet.getObject("start_time", LocalDateTime.class);
                    LocalDateTime endTime = resultSet.getObject("end_time", LocalDateTime.class);
                    Appointment.AppointmentStatus status = Appointment.AppointmentStatus.valueOf(resultSet.getString("status"));
                    appointment = new Appointment(id, customerId, serviceId, employeeId, startTime, endTime, status);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointment;
    }

    public void updateAppointment(Appointment appointment) {
        String query = "UPDATE appointments SET customer_id = ?, service_id = ?, employee_id = ?, " +
                "start_time = ?, end_time = ?, status = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, appointment.getCustomerId());
            statement.setLong(2, appointment.getServiceId());
            statement.setLong(3, appointment.getEmployeeId());
            statement.setObject(4, appointment.getStartTime());
            statement.setObject(5, appointment.getEndTime());
            statement.setString(6, appointment.getStatus().name());
            statement.setLong(7, appointment.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAppointment(Long id) {
        String query = "DELETE FROM appointments WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}

