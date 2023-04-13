package com.argusoft.appointment.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.argusoft.appointment.dao.user.UserDao;
import com.argusoft.appointment.entity.User;
import com.argusoft.appointment.utils.customannotations.LogThis;
import com.argusoft.appointment.utils.customexceptions.UnAuthenticatedException;

import jakarta.transaction.Transactional;


@Service
public class UserServiceImpl implements UserService {

    public UserServiceImpl(){
        System.out.println("Service Layer Being initalised");
    }
    @Autowired
    private UserDao userDao;


    @LogThis
    @Override
    @Transactional
    public User authenticateUser( String email,  String password) throws UnAuthenticatedException {
      
        
        User user = userDao.getUserByParam("email",email).get(0);
        if(user.getPassword().equals(password)){
            System.out.println("User Found and credentials matched");
            return user;
        }
        else{
        throw new UnAuthenticatedException("Invalide credenyials");
 }       
 
//  return null;
    }

    @LogThis
    @Override
    @Transactional
    public User deleteUserById(int id) {
        
        return userDao.deleteUserById(id);
    }

    @LogThis
    @Override
    @Transactional
    public List<User> getAllUsers() {
       
        return userDao.getUsers();
    }


    @LogThis
    @Override
    @Transactional
    public User getUserById(int id) {
       
        return userDao.getUserById(id);
    }


    @LogThis
    @Override
    @Transactional
    public User signUpUser(User user) throws DuplicateKeyException{
        if((user.getUserId() != 0 && userDao.getUserById(user.getUserId()) != null) ){
            throw new DuplicateKeyException("user with same id already exist");
        }
        return userDao.addUser(user);
    }


    @LogThis
    @Override
    @Transactional
    public User updateUserById(int id,User user) {
       
        return userDao.updateUserById(id, user);
    }
    
    
}
