package com.argusoft.appointment.service.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import com.argusoft.appointment.dao.role.RoleDao;
import com.argusoft.appointment.entity.Role;
import com.argusoft.appointment.utils.customannotations.LogThis;
import jakarta.transaction.Transactional;


@Service
public class RoleServiceImpl implements RoleService {

    public RoleServiceImpl(){
        System.out.println("Service Layer Being initalised");
    }
    @Autowired
    private RoleDao roleDao;


   
    @LogThis
    @Override
    @Transactional
    public Role deleteRoleById(int id) {
        
        return roleDao.deleteRoleById(id);
    }

    @LogThis
    @Override
    @Transactional
    public List<Role> getAllRoles() {
       
        return roleDao.getRoles();
    }


    @LogThis
    @Override
    @Transactional
    public Role getRoleById(int id) {
       
        return roleDao.getRoleById(id);
    }


    @LogThis
    @Override
    @Transactional
    public Role addRole(Role role) throws DuplicateKeyException{
        if((role.getRoleId() != 0 && roleDao.getRoleById(role.getRoleId()) != null) ){
            throw new DuplicateKeyException("role with same id already exist");
        }
        return roleDao.addRole(role);
    }


    @LogThis
    @Override
    @Transactional
    public Role updateRoleById(int id,Role role) {
       
        return roleDao.updateRoleById(id, role);
    }
    
    
}
