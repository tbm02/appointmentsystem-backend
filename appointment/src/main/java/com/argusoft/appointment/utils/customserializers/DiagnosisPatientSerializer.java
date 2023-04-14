package com.argusoft.appointment.utils.customserializers;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.argusoft.appointment.entity.Patient;
import com.argusoft.appointment.utils.serializedatatypes.DiagnosisPatient;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class DiagnosisPatientSerializer extends StdSerializer<Set<Patient>>  {
    protected DiagnosisPatientSerializer(Class<?> t, boolean dummy) {
        super(t, dummy);
        //TODO Auto-generated constructor stub
    }

   

    @Override
    public void serialize(Set<Patient> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        final Set<DiagnosisPatient> tempValueSet = new HashSet<>();
        value.forEach(patient->{
            tempValueSet.add(new DiagnosisPatient(patient.getPatientId(), patient.getFirstName(), patient.getContactNo()));
        });
        
    }
}
