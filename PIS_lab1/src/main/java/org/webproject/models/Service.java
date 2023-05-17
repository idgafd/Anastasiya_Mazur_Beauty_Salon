package main.java.org.webproject.models;

public class Service {
    private Long serviceID;
    private String serviceName;
    private Long serviceDuration;
    private double servicePrice;

    public Service(Long serviceID, String serviceName, Long serviceDuration, double servicePrice){
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.serviceDuration = serviceDuration;
        this.servicePrice = servicePrice;
    }

    public Long getServiceID() {
        return serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public Long getServiceDuration() {
        return serviceDuration;
    }

    public double getServicePrice() {
        return servicePrice;
    }

    public void setServiceID(Long serviceID) {
        this.serviceID = serviceID;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setServiceDuration(Long serviceDuration) {
        this.serviceDuration = serviceDuration;
    }

    public void setServicePrice(double servicePrice) {
        this.servicePrice = servicePrice;
    }
}
