package main.java.org.webproject.dao;

import main.java.org.webproject.models.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAO {
    private Connection connection;

    public ServiceDAO(Connection connection) {
        this.connection = connection;
    }

    public void createService(Service service) {
        String query = "INSERT INTO services (id, name, duration, price) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, service.getServiceID());
            statement.setString(2, service.getServiceName());
            statement.setLong(3, service.getServiceDuration());
            statement.setDouble(4, service.getServicePrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Service> getAllServices() {
        List<Service> services = new ArrayList<>();
        String query = "SELECT * FROM services";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Long serviceID = resultSet.getLong("id");
                String serviceName = resultSet.getString("name");
                Long serviceDuration = resultSet.getLong("duration");
                double servicePrice = resultSet.getDouble("price");
                Service service = new Service(serviceID, serviceName, serviceDuration, servicePrice);
                services.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return services;
    }

    public Service getServiceById(Long serviceID) {
        Service service = null;
        String query = "SELECT * FROM services WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, serviceID);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String serviceName = resultSet.getString("name");
                    Long serviceDuration = resultSet.getLong("duration");
                    double servicePrice = resultSet.getDouble("price");
                    service = new Service(serviceID, serviceName, serviceDuration, servicePrice);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return service;
    }

    public void updateService(Service service) {
        String query = "UPDATE services SET name = ?, duration = ?, price = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, service.getServiceName());
            statement.setLong(2, service.getServiceDuration());
            statement.setDouble(3, service.getServicePrice());
            statement.setLong(4, service.getServiceID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteService(Long serviceID) {
        String query = "DELETE FROM services WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, serviceID);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}

