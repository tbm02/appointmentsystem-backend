package com.argusoft.appointment.utils.customexceptions;

public class UnAuthenticatedException extends Throwable {

    @Override
    public synchronized Throwable fillInStackTrace() {
       
        return super.fillInStackTrace();
    }

    @Override
    public synchronized Throwable getCause() {
       
        return super.getCause();
    }

    @Override
    public String getLocalizedMessage() {
       
        return super.getLocalizedMessage();
    }

    @Override
    public String getMessage() {
       
        return super.getMessage();
    }

    @Override
    public StackTraceElement[] getStackTrace() {
       
        return super.getStackTrace();
    }

    @Override
    public synchronized Throwable initCause(Throwable arg0) {
       
        return super.initCause(arg0);
    }
    
    public UnAuthenticatedException(String message){
        super(message);
    }
    
}
