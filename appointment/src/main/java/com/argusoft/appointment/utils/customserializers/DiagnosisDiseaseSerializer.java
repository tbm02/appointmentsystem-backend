package com.argusoft.appointment.utils.customserializers;

import java.io.IOException;
import java.util.Set;

import com.argusoft.appointment.entity.Disease;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class DiagnosisDiseaseSerializer extends StdSerializer<Set<Disease>>  {

    protected DiagnosisDiseaseSerializer(Class<?> t, boolean dummy) {
        super(t, dummy);
        
    }

    @Override
    public void serialize(Set<Disease> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
// Will Apply Todo
    }
    
    
}
