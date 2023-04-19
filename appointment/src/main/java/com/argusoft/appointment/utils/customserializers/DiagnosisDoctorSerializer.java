package com.argusoft.appointment.utils.customserializers;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.argusoft.appointment.entity.Doctor;
import com.argusoft.appointment.utils.serializedatatypes.DiagnosisDoctor;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class DiagnosisDoctorSerializer extends StdSerializer<Set<Doctor>>  {
    
    protected DiagnosisDoctorSerializer(Class<?> t, boolean dummy) {
        super(t, dummy);
        //TODO Auto-generated constructor stub
    }

   

    @Override
    public void serialize(Set<Doctor> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        final Set<DiagnosisDoctor> tempValueSet = new HashSet<>();
        value.forEach(doctor->{
            tempValueSet.add(new DiagnosisDoctor(doctor.getDoctorId(), doctor.getFirstName(), doctor.getUser().getContactNo()));
        });
        
    }
    
}
