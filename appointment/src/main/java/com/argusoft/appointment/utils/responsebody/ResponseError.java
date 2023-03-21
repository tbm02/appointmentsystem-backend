package com.argusoft.appointment.utils.responsebody;

import org.springframework.http.HttpStatus;

public class ResponseError {
    private HttpStatus status;
    private String message;
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
}
