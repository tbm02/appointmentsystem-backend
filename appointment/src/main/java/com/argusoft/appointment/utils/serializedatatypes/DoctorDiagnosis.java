package com.argusoft.appointment.utils.serializedatatypes;

import java.sql.Date;

public record DoctorDiagnosis(int doctorId,int patientId,int diseaseId,int remark,Date date) {
    
}
