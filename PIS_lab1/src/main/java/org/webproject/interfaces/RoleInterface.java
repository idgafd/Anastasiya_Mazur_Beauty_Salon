package main.java.org.webproject.interfaces;

import main.java.org.webproject.models.Role;

import java.util.List;

public interface RoleInterface {
    void addRole(Role role);
    List<Role> getAllRoles();
    Role getRoleById(Long roleId);
    void updateRole(Role role);
    void deleteRole(Long roleId);
    void closeConnection();
}

