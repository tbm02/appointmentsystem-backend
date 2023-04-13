
package com.argusoft.appointment.dao.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.argusoft.appointment.entity.Role;
import com.argusoft.appointment.utils.customannotations.LogThis;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private EntityManager entityManager;

    @LogThis
    @Override
    public Role addRole(Role role) {

        entityManager.persist(role);
        return role;
    }

    @LogThis
    @Override
    public Role deleteRoleById(int id) {

        Role role = entityManager.find(Role.class, id);
        if (role != null) {
            entityManager.remove(role);
            return role;
        } else {
            throw new NoResultException("Requested Role does not exists");
        }
    }

    @LogThis
    @Override
    public Role getRoleById(int id) {

        Role role = entityManager.find(Role.class, id);
        if (role != null)
            return role;

        else {
            throw new NoResultException("Requested Role does not exists");
        }
    }

    @LogThis
    @Override
    public List<Role> getRoles() {

        TypedQuery<Role> query = entityManager.createQuery("from Role", Role.class);
        List<Role> data = query.getResultList();
        return data;
    }

    @LogThis
    @Override
    public Role updateRoleById(int id, Role updateRole) {

        Role role = entityManager.find(Role.class, id);
        if(role != null){
        updateRole.setRoleId(id);


        Role updatedRole = entityManager.merge(updateRole);

        return updatedRole;}
        else{
            throw new NoResultException("Requested Role Does not exists");
        }
    }

    @LogThis
    @Override
    public List<Role> getRoleByParam(String paramName, String paramValue) {
        System.out.println("Reached the request here " + paramName + "= = = =" + paramValue);
        String ql = "select u from Role u where u." + paramName + "=:id";

        TypedQuery<Role> query = entityManager.createQuery(ql, Role.class);
        query.setParameter("id", paramValue);

        List<Role> roleList = query.getResultList();

        return roleList;
    }

    public RoleDaoImpl() {
        System.out.println("Hii Confirmation from the dao layer ===========");
    }

}


