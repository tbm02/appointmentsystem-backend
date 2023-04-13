package com.argusoft.appointment.service.role;

import java.util.List;

import com.argusoft.appointment.entity.Role;

public interface RoleService {
    public Role addRole(Role role);
    public List<Role> getAllRoles();
    public Role getRoleById(int id);
    public Role updateRoleById(int id,Role role);
    public Role deleteRoleById(int id);
}
