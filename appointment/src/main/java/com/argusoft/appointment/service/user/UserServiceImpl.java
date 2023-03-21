package com.argusoft.appointment.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.argusoft.appointment.dao.user.UserDao;
import com.argusoft.appointment.entity.User;
import com.argusoft.appointment.utils.responsebody.UnAuthenticatedException;

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
    public User authenticateUser( String email,  String password) throws UnAuthenticatedException {
        // TODO Auto-generated method stub
        System.out.println("In Service Layer : Authenticating the user"+email+password);
        User user = userDao.getUserByParam("email",email);
        if(user.getPassword().equals(password)){
            System.out.println("User Found and credentials matched");
            return user;
        }
        else{
        throw new UnAuthenticatedException("Invalide credenyials");
 }       
 
//  return null;
    }

    @Override
    @Transactional
    public User deleteUserById(int id) {
        // TODO Auto-generated method stub
        return userDao.deleteUserById(id);
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
        return userDao.getUserById(id);
    }

    @Override
    @Transactional
    public User signUpUser(User user) {
        System.out.println("Inside Service Layer : adding the user = "+ user);
        return userDao.addUser(user);
    }

    @Override
    @Transactional
    public User updateUserById(int id,User user) {
        // TODO Auto-generated method stub
        return userDao.updateUserById(id, user);
    }
    
    
}
