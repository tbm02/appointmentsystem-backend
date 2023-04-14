package com.argusoft.appointment.utils.customserializers;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.argusoft.appointment.entity.Person;
import com.argusoft.appointment.utils.serializedatatypes.PatientPerson;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class PatientPersonSerializer extends StdSerializer<Set<Person>>  {

    protected PatientPersonSerializer(Class<Set<Person>> t) {
        super(t);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void serialize(Set<Person> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        final Set<PatientPerson> tempValueSet = new HashSet<>();
        value.forEach(person->{
            tempValueSet.add(new PatientPerson(person.getFirstName(),person.getLastName(),person.getEmail()));
        });
        
    }
    
    
}
