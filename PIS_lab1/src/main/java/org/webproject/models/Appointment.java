package main.java.org.webproject.models;

import java.time.LocalDateTime;

public class Appointment {
    public enum AppointmentStatus {
        OPENED,
        PENDING,
        CONFIRMED,
        CANCELLED
    }

    private Long id;
    private Long customerId;
    private Long serviceId;
    private Long employeeId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private AppointmentStatus status;

    public Appointment(Long id, Long customerId, Long serviceId, Long employeeId, LocalDateTime startTime,
                       LocalDateTime endTime, AppointmentStatus status) {
        this.id = id;
        this.customerId = customerId;
        this.serviceId = serviceId;
        this.employeeId = employeeId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }
}
