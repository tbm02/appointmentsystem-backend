package com.argusoft.appointment.utils.customserializers;

import java.io.IOException;
import java.util.HashSet;

import com.argusoft.appointment.entity.Specialization;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.util.Set;

public class DoctorSpecializationSerializer extends StdSerializer<Set<Specialization>>  {

    protected DoctorSpecializationSerializer(Class<?> t, boolean dummy) {
        super(t, dummy);
        //TODO Auto-generated constructor stub
    }
    public DoctorSpecializationSerializer() {
        this(null,true);
    }
   

    @Override
    public void serialize(Set<Specialization> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        final Set<String> tempValues = new HashSet<>();
        System.out.println("Serializing");
        value.forEach(specialization->{
            tempValues.add(specialization.getSpecializationName());
        });

        gen.writeObject(tempValues);
        
    }

   
    


    
}
