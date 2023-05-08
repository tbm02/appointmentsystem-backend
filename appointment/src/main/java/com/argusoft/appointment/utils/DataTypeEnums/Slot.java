package com.argusoft.appointment.utils.DataTypeEnums;

import java.sql.Time;
import java.time.LocalTime;

public class Slot {
    private LocalTime time;
    private boolean booked;
    public Slot(LocalTime temp,boolean booked){
        this.time = temp;
        this.booked = booked;

    }    
    public void setTime(LocalTime t){
        this.time = t;
    }
    public void setBooked(boolean b){
        this.booked = b;
    }
    public LocalTime getTime(){
        return this.time;
    }
    public boolean getBooked(){
        return this.booked;
    }
}
