package com.argusoft.appointment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
// import jakarta.validation.OverridesAttribute.List;
import java.util.List;

@Entity
@Table(name = "Role")
public class Role {

    @Column(name = "roleId  ")
    private int roleId;

    @Column(name = "roleName")
    private String roleName;


    @OneToMany(mappedBy = "userRoleId")
    private List<User> users;

    
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Roles [roleId=" + roleId + ", roleName=" + roleName + "]";
    }

    public Role(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }


    
}
