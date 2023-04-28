package com.argusoft.appointment.utils.customserializers;

import java.io.IOException;

import com.argusoft.appointment.entity.Patient;
import com.argusoft.appointment.utils.serializedatatypes.AppointmentPatient;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class AppointmentPatientSerializer extends StdSerializer<Patient> {

    protected AppointmentPatientSerializer(Class<Patient> t) {
        super(t);
        // TODO Auto-generated constructor stub
    }
    public AppointmentPatientSerializer() {
        this(null);
    }

    @Override
    public void serialize(Patient patient, JsonGenerator gen, SerializerProvider provider) throws IOException {

        gen.writeObject(new AppointmentPatient(patient.getPatientId(), patient.getFirstName(), patient.getLastName(), patient.getContactNo()));
    }
    
    
}
