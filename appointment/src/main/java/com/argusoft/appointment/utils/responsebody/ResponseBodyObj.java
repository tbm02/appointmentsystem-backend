package com.argusoft.appointment.utils.responsebody;

import org.springframework.http.HttpStatus;

public class ResponseBodyObj<T> {
    private HttpStatus statusCode;
    private String message;
    private T data;
    public HttpStatus getStatusCode() {
        return statusCode;
    }
    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }
    public String getmMssage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public ResponseBodyObj(HttpStatus statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public ResponseBodyObj(HttpStatus statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
    
}
