package main.java.org.webproject.models;
import java.util.HashMap;
import java.util.Map;

public class User {
    private Long userId;
    private String userName;
    private String userEmail;
    private String userPassword;

    private Long roleId;

    private static final Map<Long, String> roleMapping = new HashMap<>();

    static {
        roleMapping.put(1L, "Administrator");
        roleMapping.put(2L, "Master");
        roleMapping.put(3L, "Client");
    }

    public User(Long userId, String userName, String userEmail, String userPassword, Long roleId){
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.roleId = roleId;
    }

    @Override
    public String toString(){
        String roleName = roleMapping.get(roleId);
        return "User ID: " + userId.toString() +
                "\tRole: " + roleName +
                "\tName: " + userName +
                "\tEmail: " + userEmail +
                "\tPass: " + userPassword;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
