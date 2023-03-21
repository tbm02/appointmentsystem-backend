package com.argusoft.appointment.controller.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
import com.argusoft.appointment.utils.request.LoginRequest;
import com.argusoft.appointment.utils.responsebody.ResponseBodyObj;
import com.argusoft.appointment.utils.responsebody.ResponseError;
import com.argusoft.appointment.utils.responsebody.UnAuthenticatedException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("")
    public ResponseEntity<ResponseBodyObj> signUpUser(@RequestBody User user){
        
        System.out.println("Controller: createing the requested User"+user);
        ResponseBodyObj<User> res = new ResponseBodyObj(HttpStatus.OK, "User creatded succefully", (User) userService.signUpUser(user));
        return new ResponseEntity<ResponseBodyObj>(res,HttpStatus.OK);
    }


    @PostMapping("/login")
    public ResponseEntity<ResponseBodyObj> loginUser(@RequestBody LoginRequest<String,String> user) throws UnAuthenticatedException{
        System.out.println("Controller: Autjeticating  the requested User");
        User u = userService.authenticateUser(user.getEmail(),user.getPassword());
        ResponseBodyObj<User> res = new ResponseBodyObj<>(HttpStatus.OK, "Authenticated Success",u);
        
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @GetMapping("/")
    public List<User> getAllUsers(){
        System.out.println("Get request is called");
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id ){
        System.out.println("Get request for Id is called id = "+id);
        
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user,@PathVariable int id){
        System.out.println("Controller: createing the requested User"+user);

        return userService.updateUserById(id,user);
    }

    @DeleteMapping("/{id}")
    public User deleteUser(@RequestBody User user,@PathVariable int id){
        System.out.println("Controller: createing the requested User"+user);

        return userService.deleteUserById(id);
    }
    public UserController(){

    }
    @ExceptionHandler(value = jakarta.persistence.NoResultException.class)
    public ResponseEntity<ResponseBodyObj> handleNullPointer(){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = java.sql.SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ResponseError> handleIntegrity(){
        ResponseError error = new ResponseError(HttpStatus.BAD_REQUEST, "Please match the constraunts");
                return new ResponseEntity<ResponseError>(error,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = UnAuthenticatedException.class)
    public ResponseEntity<ResponseError> handleUnathentic(){
        ResponseError error = new ResponseError(HttpStatus.UNAUTHORIZED, "You are not allowed to access");
                return new ResponseEntity<ResponseError>(error,HttpStatus.UNAUTHORIZED);
    }
}
