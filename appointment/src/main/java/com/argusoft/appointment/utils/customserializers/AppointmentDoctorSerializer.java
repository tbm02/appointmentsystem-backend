package com.argusoft.appointment.utils.customserializers;


import com.argusoft.appointment.utils.serializedatatypes.AppointmentDoctor;
import com.argusoft.appointment.entity.Doctor;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import io.jsonwebtoken.io.IOException;

public class AppointmentDoctorSerializer extends StdSerializer<Doctor> {
    protected AppointmentDoctorSerializer(Class<Doctor> t) {
        super(t);
        // TODO Auto-generated constructor stub
    }
    public AppointmentDoctorSerializer() {
        this(null);
    }

    @Override
    public void serialize(Doctor doctor, JsonGenerator gen, SerializerProvider provider) throws IOException, java.io.IOException {

        gen.writeObject(new AppointmentDoctor(doctor.getDoctorId(),doctor.getFirstName(),doctor.getLastName(),doctor.getUser().getContactNo()));
        
    }
    
    
}
