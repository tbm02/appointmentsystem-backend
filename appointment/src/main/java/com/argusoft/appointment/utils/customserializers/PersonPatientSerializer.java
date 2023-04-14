package com.argusoft.appointment.utils.customserializers;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.argusoft.appointment.entity.Patient;
import com.argusoft.appointment.entity.Person;
import com.argusoft.appointment.utils.serializedatatypes.PersonPatient;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class PersonPatientSerializer extends StdSerializer<Set<Patient>> {
    protected PersonPatientSerializer(Class<Set<Patient>> t) {
        super(t);
        // TODO Auto-generated constructor stub
    }
    public PersonPatientSerializer() {
        this(null);
    }
    @Override
    public void serialize(Set<Patient> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        final Set<PersonPatient> tempValueSet = new HashSet<>();
        value.forEach(patient -> {
            System.out.println(patient);
            tempValueSet.add(new PersonPatient(patient.getPatientId(), patient.getFirstName(), patient.getLastName(),
                    patient.getEmail()));
        });
        gen.writeObject(tempValueSet);
    }
}
