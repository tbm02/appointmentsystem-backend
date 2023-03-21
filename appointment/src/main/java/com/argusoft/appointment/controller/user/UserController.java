package com.argusoft.appointment.controller.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.argusoft.appointment.entity.User;
import com.argusoft.appointment.service.user.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signUp")
    public User signUpUser(@RequestBody User user){
        System.out.println("Controller: createing the requested User"+user);

        return userService.signUpUser(user);
    }


    @PostMapping("/login")
    public User loginUser(@RequestBody Map<String,String> user){
        System.out.println("Controller: Autjeticating  the requested User");

        return userService.authenticateUser("user","user");
    }

    @GetMapping("/")
    public List<User> getAllUsers(){
        System.out.println("Get request is called");
        return userService.getAllUsers();
    }

    public UserController(){
        System.out.println("I am being initialise");
    }
}
