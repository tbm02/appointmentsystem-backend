package com.argusoft.appointment.utils.exceptionhandlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.argusoft.appointment.utils.customexceptions.UnAuthenticatedException;
import com.argusoft.appointment.utils.responsebody.ErrorObj;
import com.argusoft.appointment.utils.responsebody.ResponseError;

@ControllerAdvice
public class ControllerExceptionHandler {
    
    @ExceptionHandler(value = org.springframework.web.bind.MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseError<ErrorObj<String,String>>> validateUser(org.springframework.web.bind.MethodArgumentNotValidException e) {
        List<ErrorObj<String,String>> errors = new ArrayList<>();
       for(ObjectError err:e.getAllErrors()){
        System.out.println(err.getCodes()+"==================================");
        errors.add(new ErrorObj<String,String>(err.getCode(),err.getDefaultMessage()));
       }
        ResponseError<ErrorObj<String,String>> error = new ResponseError(HttpStatus.BAD_REQUEST, "Please Match Validations",errors);
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(value = jakarta.persistence.NoResultException.class)
    public ResponseEntity<ResponseError<String>> handleNoResultFound(jakarta.persistence.NoResultException e) {
        ResponseError<String> error = new ResponseError<>(HttpStatus.BAD_REQUEST, "Unable to find user for" + e.getMessage());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(value = DuplicateKeyException.class)
    public ResponseEntity<ResponseError<String>> duplicateKey(DuplicateKeyException e) {
        ResponseError<String> error = new ResponseError<>(HttpStatus.BAD_REQUEST, "Duplicate Entry error for" + e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = java.sql.SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ResponseError<Object>> handleIntegrity(java.sql.SQLIntegrityConstraintViolationException e) {
        ResponseError<Object> error = new ResponseError<>(HttpStatus.BAD_REQUEST, "Please match the constraunts");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = UnAuthenticatedException.class)
    public ResponseEntity<ResponseError<Object>> handleUnathentic(UnAuthenticatedException e) {
        ResponseError<Object> error = new ResponseError<>(HttpStatus.UNAUTHORIZED, "You are not allowed to access");
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<ResponseError<Object>> handleIlleagleArgumentException(IllegalArgumentException e) {
        System.out.println(e.getMessage());
        ResponseError<Object> error = new ResponseError<>(HttpStatus.BAD_REQUEST, "Error While Attemping to "+e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ResponseError<Object>> genericException(Exception e) {
        System.out.println(e.getMessage());
        ResponseError<Object> error = new ResponseError<>(HttpStatus.BAD_REQUEST, "Error While Attemping to "+e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

  
}
