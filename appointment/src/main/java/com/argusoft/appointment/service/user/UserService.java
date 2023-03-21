package com.argusoft.appointment.service.user;

import java.util.List;

import com.argusoft.appointment.entity.User;
import com.argusoft.appointment.utils.responsebody.UnAuthenticatedException;

public interface UserService {
    
    public User signUpUser(User user);
    public User authenticateUser(String email,String password) throws UnAuthenticatedException;
    public List<User> getAllUsers();
    public User getUserById(int id);
    public User updateUserById(int id,User user);
    public User deleteUserById(int id);
    
}
