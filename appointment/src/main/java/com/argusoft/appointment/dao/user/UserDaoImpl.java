package com.argusoft.appointment.dao.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.argusoft.appointment.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;


@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private EntityManager entityManager;
    @Override
    public User addUser(User user) {
       
        System.out.println("Inside Dao Layer : Creating the User");
        entityManager.merge(user);
        return user;
    }

    @Override
    public User deleteUserById(int id) {
        
        User user = getUserById(id);

        Query query = entityManager.createQuery("delete from User where userId =:id");
        query.setParameter("id",id);
        query.executeUpdate();
        return user;
    }

    @Override
    public User getUserById(int id) {
        
        User user = entityManager.find(User.class, id);

        return user;
    }

    @Override
    public List<User> getUsers() {
        
        Query query = entityManager.createQuery("from User");
        List<User> data = query.getResultList();
        return data;
    }

    @Override
    public User updateUserById(int id,User updateUser) {
        
        User updatedUser = entityManager.merge(updateUser);
        return updatedUser;
    }

    @Override
    public User getUserByParam(String paramName,String paramValue) {
        
        String ql = "from User where "+paramName+"=:"+paramValue;
        Query query = entityManager.createQuery(ql);

        User user = (User) query.getSingleResult();

        return user;
    }

    public UserDaoImpl(){
        System.out.println("Hii Confirmation from the dao layer ===========");
    }
    
    
}
