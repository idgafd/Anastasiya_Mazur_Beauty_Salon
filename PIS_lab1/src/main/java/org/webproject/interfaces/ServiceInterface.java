package main.java.org.webproject.interfaces;

import main.java.org.webproject.models.Service;

import java.util.List;

public interface ServiceInterface {
    void createService(Service service);
    List<Service> getAllServices();
    Service getServiceById(Long serviceID);
    void updateService(Service service);
    void deleteService(Long serviceID);
    void closeConnection();
}

