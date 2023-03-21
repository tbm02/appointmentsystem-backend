package com.argusoft.appointment.utils.request;

public class LoginRequest<E,P> {

    private E email;
    private P password;
    public E getEmail() {
        return email;
    }
    public void setEmail(E email) {
        this.email = email;
    }
    public P getPassword() {
        return password;
    }
    public void setPassword(P password) {
        this.password = password;
    }

    
    
}
