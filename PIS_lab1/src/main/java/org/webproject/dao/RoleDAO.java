package main.java.org.webproject.dao;

import main.java.org.webproject.models.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO {
    private Connection connection;

    public RoleDAO(Connection connection) {
        this.connection = connection;
    }

    public void addRole(Role role) {
        String query = "INSERT INTO roles (role_id, role_name) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, role.getRoleId());
            statement.setString(2, role.getRoleName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Role> getAllRoles() {
        List<Role> roles = new ArrayList<>();
        String query = "SELECT * FROM roles";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Long roleId = resultSet.getLong("id");
                String roleName = resultSet.getString("role_name");
                Role role = new Role(roleId, roleName);
                roles.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    public Role getRoleById(Long roleId) {
        Role role = null;
        String query = "SELECT * FROM roles WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, roleId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String roleName = resultSet.getString("role_name");
                    role = new Role(roleId, roleName);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    public void updateRole(Role role) {
        String query = "UPDATE roles SET role_name = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, role.getRoleName());
            statement.setLong(2, role.getRoleId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRole(Long roleId) {
        String query = "DELETE FROM roles WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, roleId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

}
