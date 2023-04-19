package com.argusoft.appointment.dao.user;

import com.argusoft.appointment.entity.User;
import com.argusoft.appointment.utils.customannotations.LogThis;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


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
    public User updateUserById(int id, User updateUser) {

        User user = entityManager.find(User.class, id);
        if(user != null){
        updateUser.setUserId(id);

        if(updateUser.getRole()==null){
            updateUser.setRole(user.getRole());

        }

        return entityManager.merge(updateUser);}
        else{
            throw new NoResultException("Requested User Does not exists");
        }
    }

    @LogThis
    @Override
    public User getUserById(int id) {
        
        return entityManager.find(User.class, id);
    }


    @LogThis
    @Override
    public List<User> getUsers() {
        
        TypedQuery<User> query = entityManager.createQuery("from User",User.class);
        return query.getResultList();
    }


    @LogThis
    @Override
    public <T,V> List<User> getUserByParam(String paramName,T paramType,V paramValue) {
        System.out.println("Reached the request here "+paramName+"= = = ="+paramValue);
        String ql = "select u from User u where u."+paramName+"=:id";

        TypedQuery<User> query = entityManager.createQuery(ql, User.class);
        query.setParameter("id",paramValue);
        
        return query.getResultList();
    }



    public UserDaoImpl(){
        System.out.println("Hii Confirmation from the dao layer ===========");
    }
    
    
}
