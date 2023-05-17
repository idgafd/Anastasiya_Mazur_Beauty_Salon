package main.java.org.webproject.interfaces;

import main.java.org.webproject.models.User;

import java.util.List;

public interface UserInterface {
    void createUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    void updateUser(User user);
    void deleteUser(Long id);
    void closeConnection();
}

