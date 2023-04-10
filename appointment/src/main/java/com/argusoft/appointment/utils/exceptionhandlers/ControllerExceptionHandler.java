package com.argusoft.appointment.utils.exceptionhandlers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.argusoft.appointment.utils.customexceptions.UnAuthenticatedException;
import com.argusoft.appointment.utils.responsebody.ResponseError;

@ControllerAdvice
public class ControllerExceptionHandler {
    
    @ExceptionHandler(value = org.springframework.web.bind.MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseError> validateUser(org.springframework.web.bind.MethodArgumentNotValidException e) {
        List<String> errors = new ArrayList<>();
       for(ObjectError err:e.getAllErrors()){
        errors.add(err.getDefaultMessage());
       }
        ResponseError error = new ResponseError(HttpStatus.BAD_REQUEST, "Please Match Validations",errors);
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(value = jakarta.persistence.NoResultException.class)
    public ResponseEntity<ResponseError> handleNoResultFound(jakarta.persistence.NoResultException e) {
        ResponseError error = new ResponseError(HttpStatus.BAD_REQUEST, "Unable to find user for" + e.getMessage());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(value = DuplicateKeyException.class)
    public ResponseEntity<ResponseError> duplicateKey(DuplicateKeyException e) {
        ResponseError error = new ResponseError(HttpStatus.BAD_REQUEST, "Duplicate Entry error for" + e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = java.sql.SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ResponseError> handleIntegrity(java.sql.SQLIntegrityConstraintViolationException e) {
        ResponseError error = new ResponseError(HttpStatus.BAD_REQUEST, "Please match the constraunts");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = UnAuthenticatedException.class)
    public ResponseEntity<ResponseError> handleUnathentic() {
        ResponseError error = new ResponseError(HttpStatus.UNAUTHORIZED, "You are not allowed to access");
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }
}
