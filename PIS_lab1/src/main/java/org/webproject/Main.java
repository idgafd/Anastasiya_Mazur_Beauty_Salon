package main.java.org.webproject;

import main.java.org.webproject.dao.RoleDAO;
import main.java.org.webproject.models.Role;
import main.java.org.webproject.conection.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import main.java.org.webproject.dao.*;
import main.java.org.webproject.models.*;


public class Main {
    public static void main(String[] args) {
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance();
            Connection connection = connectionPool.getConnection();

            // Приклад використання RoleDAO
            RoleDAO roleDAO = new RoleDAO(connection);
            List<Role> roles = roleDAO.getAllRoles();
            System.out.println("List of Roles: ");
            for (Role role : roles) {
                System.out.println(role.toString());
            }

            // Приклад вставки нового користувача
            UserDAO userDAO = new UserDAO(connection);
            User newUser = new User(4L, "mary", "mary@example.com", "password", 3L);
            userDAO.createUser(newUser);
            System.out.println("New user inserted: " + newUser.toString());

            // Приклад вставки нового сервісу
            ServiceDAO serviceDAO = new ServiceDAO(connection);
            Service newService = new Service(2L, "Nails", 80L, 50.0);
            serviceDAO.createService(newService);
            System.out.println("New service inserted: " + newService.toString());

            // Приклад оновлення тривалості сервісу
            long serviceIdToUpdate = 2L;
            Service serviceToUpdate = serviceDAO.getServiceById(serviceIdToUpdate);
            if (serviceToUpdate != null) {
                serviceToUpdate.setServiceDuration(90L);
                serviceDAO.updateService(serviceToUpdate);
                System.out.println("Service updated: " + serviceToUpdate.toString());
            }

            // Приклад вставки нового призначення
            AppointmentDAO appointmentDAO = new AppointmentDAO(connection);

            LocalDateTime startTime = LocalDateTime.of(2023, 5, 19, 10, 0);
            LocalDateTime endTime = LocalDateTime.of(2023, 5, 19, 12, 0);

            Appointment newAppointment = new Appointment(1L, 1L, 1L, 1L, startTime, endTime, Appointment.AppointmentStatus.OPENED);
            appointmentDAO.createAppointment(newAppointment);
            System.out.println("New appointment inserted: " + newAppointment.toString());


            // Приклад вставки нового відгуку
            ReviewDAO reviewDAO = new ReviewDAO(connection);
            Review newReview = new Review(1L, 1L, 5, "Great service!");
            reviewDAO.createReview(newReview);
            System.out.println("New review inserted: " + newReview.toString());

            // Приклад видалення відгуку
            long reviewIdToDelete = 1L;
            reviewDAO.deleteReview(reviewIdToDelete);
            System.out.println("Review deleted with ID: " + reviewIdToDelete);

            connectionPool.releaseConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


/*
public class Main {
    public static void main(String[] args) {
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance();
            RoleDAO roleDAO = new RoleDAO(connectionPool.getConnection());

            // Використання RoleDAO для отримання ролей
            List<Role> roles = roleDAO.getAllRoles();
            for (Role role : roles) {
                System.out.println(role.toString());
            }

            connectionPool.releaseConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
*/

