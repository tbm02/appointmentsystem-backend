package com.argusoft.appointment.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.argusoft.appointment.dao.user.UserDao;
import com.argusoft.appointment.entity.User;

import jakarta.transaction.Transactional;


@Service
public class UserServiceImpl implements UserService {

    public UserServiceImpl(){
        System.out.println("Service Layer Being initalised");
    }
    @Autowired
    private UserDao userDao;


    @Override
    @Transactional
    public User authenticateUser( String email,  String password) {
        // TODO Auto-generated method stub
        System.out.println("In Service Layer : Authenticating the user");
        User user = userDao.getUserByParam("email",email);
        if(user.getPassword().equals(password)){
            System.out.println("User Found and credentials matched");
            return user;
        }
        return null;
    }

    @Override
    @Transactional
    public User deleteUserById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        // TODO Auto-generated method stub
        return userDao.getUsers();
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Transactional
    public User signUpUser(User user) {
        System.out.println("Inside Service Layer :");
        return userDao.addUser(user);
    }

    @Override
    @Transactional
    public User updateUserById(int id) {
        // TODO Auto-generated method stub
        return null;
    }
    
    
}
