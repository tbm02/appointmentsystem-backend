package com.argusoft.appointment.utils.customexceptions;

public class UnAuthenticatedException extends Throwable {

    @Override
    public synchronized Throwable fillInStackTrace() {
        // TODO Auto-generated method stub
        return super.fillInStackTrace();
    }

    @Override
    public synchronized Throwable getCause() {
        // TODO Auto-generated method stub
        return super.getCause();
    }

    @Override
    public String getLocalizedMessage() {
        // TODO Auto-generated method stub
        return super.getLocalizedMessage();
    }

    @Override
    public String getMessage() {
        // TODO Auto-generated method stub
        return super.getMessage();
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        // TODO Auto-generated method stub
        return super.getStackTrace();
    }

    @Override
    public synchronized Throwable initCause(Throwable arg0) {
        // TODO Auto-generated method stub
        return super.initCause(arg0);
    }
    
    public UnAuthenticatedException(String message){
        super(message);
    }
    
}
