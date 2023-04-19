package com.argusoft.appointment.dao.user;

import com.argusoft.appointment.entity.User;

import java.util.List;

public interface UserDao {

    public User addUser(User user) ;
    public List<User> getUsers();
    public User getUserById(int id);
    public User updateUserById(int id,User updatedUser);
    public User deleteUserById(int id);
    public <T,V> List<User> getUserByParam(String paramName,T paramType,V paramValue);

}
