package com.argusoft.appointment.controller.patient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.argusoft.appointment.utils.responsebody.ResponseBodyObj;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/patient")
@CrossOrigin("http://localhost:4200")
public class PatientController {
    @Autowired
    private PatientService patientService;


    @LogThis
    @PostMapping(value = {"","/"})
    public ResponseEntity<ResponseBodyObj<Patient>> addNewPatient(@RequestBody @Valid Patient patient)
    throws DuplicateKeyException, org.springframework.web.bind.MethodArgumentNotValidException{
        
        
        ResponseBodyObj<Patient> res = new ResponseBodyObj<>(HttpStatus.OK, "Patient creatded succefully",  patientService.addPatient(patient));
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    


    @LogThis
    @GetMapping(value = {"","/"})
    public ResponseEntity<ResponseBodyObj<List<Patient>>> getAllPatients(){
        ResponseBodyObj<List<Patient>> res = new ResponseBodyObj<>(HttpStatus.OK, "List Of Patients",  patientService.getAllPatients());
        return new ResponseEntity<>(res,HttpStatus.OK);
    }


    @LogThis
    @GetMapping("/{id}")
    public ResponseEntity<ResponseBodyObj<Patient>> getPatientById(@PathVariable int id ){
        
        
        ResponseBodyObj<Patient> res = new ResponseBodyObj<>(HttpStatus.OK, "Requsted Patient",  patientService.getPatientById(id));
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @LogThis
    @GetMapping("/person/{id}")
    public ResponseEntity<ResponseBodyObj<List<Patient>>> getPatientByPersonId(@PathVariable int id ){
        
        
        ResponseBodyObj<List<Patient>> res = new ResponseBodyObj<>(HttpStatus.OK, "Requsted Patient",  patientService.getAllPatientsByPersonId(id));
        return new ResponseEntity<>(res,HttpStatus.OK);
    }


    @LogThis
    @PutMapping("/{id}")
    public ResponseEntity<ResponseBodyObj<Patient>> updatePatient(@RequestBody @Valid Patient patient,@PathVariable int id)
    throws  org.springframework.web.bind.MethodArgumentNotValidException{
        
        ResponseBodyObj<Patient> res = new ResponseBodyObj<>(HttpStatus.OK, "Updated Patient",  patientService.updatePatientById(id,patient));
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @LogThis
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBodyObj<Patient>> deletePatient(@PathVariable int id){
        

        ResponseBodyObj<Patient> res = new ResponseBodyObj<>(HttpStatus.OK, "Deleted Patient",  patientService.deletePatientById(id));
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
   
   
}
