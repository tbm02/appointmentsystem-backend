package com.argusoft.appointment.dao.user;

import java.util.List;

import com.argusoft.appointment.entity.User;

public interface UserDao {


    public User addUser(User user) ;
    public List<User> getUsers();
    public User getUserById(int id);
    public User updateUserById(int id,User updatedUser);
    public User deleteUserById(int id);  
    public User getUserByParam(String paramName,String paramValue); 
}
