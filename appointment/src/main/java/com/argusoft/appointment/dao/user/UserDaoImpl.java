package com.argusoft.appointment.dao.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.argusoft.appointment.entity.User;
import com.argusoft.appointment.utils.customannotations.LogThis;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private EntityManager entityManager;

    @LogThis
    @Override
    public User addUser(User user) {

        entityManager.persist(user);
        return user;
    }

    @LogThis
    @Override
    public User deleteUserById(int id) {

        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
            return user;
        } else {
            throw new NoResultException("Requested User does not exists");
        }
    }

    @LogThis
    @Override
    public User getUserById(int id) {

        User user = entityManager.find(User.class, id);
        if (user != null)
            return user;

        else {
            throw new NoResultException("Requested User does not exists");
        }
    }

    @LogThis
    @Override
    public List<User> getUsers() {

        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        List<User> data = query.getResultList();
        return data;
    }

    @LogThis
    @Override
    public User updateUserById(int id, User updateUser) {

        User user = entityManager.find(User.class, id);
        if(user != null){
        updateUser.setId(id);


        User updatedUser = entityManager.merge(updateUser);

        return updatedUser;}
        else{
            throw new NoResultException("Requested User Does not exists");
        }
    }

    @LogThis
    @Override
    public List<User> getUserByParam(String paramName, String paramValue) {
        System.out.println("Reached the request here " + paramName + "= = = =" + paramValue);
        String ql = "select u from User u where u." + paramName + "=:id";

        TypedQuery<User> query = entityManager.createQuery(ql, User.class);
        query.setParameter("id", paramValue);

        List<User> userList = query.getResultList();

        return userList;
    }

    public UserDaoImpl() {
        System.out.println("Hii Confirmation from the dao layer ===========");
    }

}
