package main.java.org.webproject.models;

public class Role {
    private Long roleId;
    private String roleName;

    public Role(Long roleId, String roleName){
        this.roleId = roleId;
        this.roleName = roleName;
    }

    @Override
    public String toString(){
        return "Role ID: " + roleId.toString() +
                "\tRole: " + roleName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
