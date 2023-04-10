package com.argusoft.appointment.controller.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.argusoft.appointment.entity.User;
import com.argusoft.appointment.service.user.UserService;
import com.argusoft.appointment.utils.customannotations.LogThis;
import com.argusoft.appointment.utils.customexceptions.UnAuthenticatedException;
import com.argusoft.appointment.utils.request.LoginRequest;
import com.argusoft.appointment.utils.responsebody.ResponseBodyObj;
import com.argusoft.appointment.utils.responsebody.ResponseError;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @LogThis
    @PostMapping(value = { "", "/" })
    public ResponseEntity<ResponseBodyObj<User>> signUpUser( @RequestBody @Valid User user) throws DuplicateKeyException,org.springframework.web.bind.MethodArgumentNotValidException {

        ResponseBodyObj<User> res = new ResponseBodyObj(HttpStatus.OK, "User creatded succefully",
                (User) userService.signUpUser(user));
        return new ResponseEntity<ResponseBodyObj<User>>(res, HttpStatus.OK);
    }

    @LogThis
    @PostMapping(value = { "/login", "/login/" })
    public ResponseEntity<ResponseBodyObj<User>> loginUser(@RequestBody LoginRequest<String, String> user)
            throws UnAuthenticatedException {

        User u = userService.authenticateUser(user.getEmail(), user.getPassword());
        ResponseBodyObj<User> res = new ResponseBodyObj<>(HttpStatus.OK, "Authenticated Success", u);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @LogThis
    @GetMapping(value = { "", "/" })
    public List<User> getAllUsers() {

        return userService.getAllUsers();
    }

    @LogThis
    @GetMapping("/{id}")
    public ResponseEntity<ResponseBodyObj<User>> getUserById(@PathVariable int id) {
        User user = userService.getUserById(id);

        ResponseBodyObj<User> res = new ResponseBodyObj<>(HttpStatus.OK, "Requested User", user);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @LogThis
    @PutMapping("/{id}")
    public User updateUser(@RequestBody @Valid User user, @PathVariable int id) {

        return userService.updateUserById(id, user);
    }

    @LogThis
    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable int id) {

        return userService.deleteUserById(id);
    }

    public UserController() {

    }
    
}
