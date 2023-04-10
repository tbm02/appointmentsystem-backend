package com.argusoft.appointment.controller.patient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.argusoft.appointment.entity.Patient;
import com.argusoft.appointment.service.patient.PatientService;
import com.argusoft.appointment.utils.customannotations.LogThis;
import com.argusoft.appointment.utils.customexceptions.UnAuthenticatedException;
import com.argusoft.appointment.utils.request.LoginRequest;
import com.argusoft.appointment.utils.responsebody.ResponseBodyObj;
import com.argusoft.appointment.utils.responsebody.ResponseError;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;


    @LogThis
    @PostMapping(value = {"","/"})
    public ResponseEntity<ResponseBodyObj> addNewPatient(@RequestBody Patient patient){
        
        
        ResponseBodyObj<Patient> res = new ResponseBodyObj(HttpStatus.OK, "Patient creatded succefully", (Patient) patientService.addPatient(patient));
        return new ResponseEntity<ResponseBodyObj>(res,HttpStatus.OK);
    }

    


    @LogThis
    @GetMapping(value = {"","/"})
    public List<Patient> getAllPatients(){
        
        return patientService.getAllPatients();
    }


    @LogThis
    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable int id ){
        
        
        return patientService.getPatientById(id);
    }


    @LogThis
    @PutMapping("/{id}")
    public Patient updatePatient(@RequestBody Patient patient,@PathVariable int id){
        
        return patientService.updatePatientById(id,patient);
    }

    @LogThis
    @DeleteMapping("/{id}")
    public Patient deletePatient(@PathVariable int id){
        

        return patientService.deletePatientById(id);
    }
    public PatientController(){

    }
    
   
}
