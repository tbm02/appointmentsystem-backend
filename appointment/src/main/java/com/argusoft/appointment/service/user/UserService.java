package com.argusoft.appointment.service.user;

import java.util.List;

import com.argusoft.appointment.entity.User;

public interface UserService {
    
    public User signUpUser(User user);
    public User authenticateUser(String email,String password);
    public List<User> getAllUsers();
    public User getUserById(int id);
    public User updateUserById(int id);
    public User deleteUserById(int id);
    
}
