package com.argusoft.appointment.utils.responsebody;

import org.springframework.http.HttpStatus;

public class ResponseError <T>{
    private HttpStatus status;
    private String message;
    private T errorObj;
    public HttpStatus getStatus() {
        return status;
    }
    public void setStatus(HttpStatus status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    
    public ResponseError(HttpStatus status,String message){
        this.status = status;
        this.message = message;

    }
    public ResponseError(HttpStatus status, String message, T errorObj) {
        this.status = status;
        this.message = message;
        this.errorObj = errorObj;
    }
    public T getErrorObj() {
        return errorObj;
    }
    public void setErrorObj(T errorObj) {
        this.errorObj = errorObj;
    }

    

}
