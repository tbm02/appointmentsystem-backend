package com.argusoft.appointment.utils.customserializers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import com.argusoft.appointment.entity.Doctor;
import com.argusoft.appointment.entity.Specialization;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import jakarta.validation.OverridesAttribute.List;

import java.util.Set;

public class SpecializationDoctorSerializer extends StdSerializer<Set<Doctor>>  {

    protected SpecializationDoctorSerializer(Class<?> t, boolean dummy) {
        super(t, dummy);
     
    }
    public SpecializationDoctorSerializer() {
        this(null,true);
    }
    
    @Override
    public void serialize(Set<Doctor> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        final Set<Integer> tempValues = new HashSet<>();
        value.forEach(doctor->{
            tempValues.add(doctor.getDoctorId());
        });

        gen.writeObject(tempValues);
        
    }

   
    


    
}
