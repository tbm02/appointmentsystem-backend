package com.argusoft.appointment.dao.role;

import java.util.List;

import com.argusoft.appointment.entity.Role;

public interface RoleDao {

    public Role addRole(Role role);
    public List<Role> getRoles();
    public Role getRoleById(int id);
    public Role updateRoleById(int id,Role updatedRole);
    public Role deleteRoleById(int id);  
    public List<Role> getRoleByParam(String paramName,String paramValue); 
    
}
