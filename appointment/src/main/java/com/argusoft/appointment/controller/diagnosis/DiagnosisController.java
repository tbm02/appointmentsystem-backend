package com.argusoft.appointment.controller.diagnosis;

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

import com.argusoft.appointment.entity.Diagnosis;
import com.argusoft.appointment.service.diagnosis.DiagnosisService;
import com.argusoft.appointment.utils.customannotations.LogThis;
import com.argusoft.appointment.utils.responsebody.ResponseBodyObj;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/diagnosis")
@CrossOrigin("http://localhost:4200")
public class DiagnosisController {

    @Autowired
    private DiagnosisService diagnosisService;


    @LogThis
    @PostMapping(value = {"","/"})
    public ResponseEntity<ResponseBodyObj<Diagnosis>> addDiagnosis(@RequestBody @Valid Diagnosis diagnosis)
    throws DuplicateKeyException, org.springframework.web.bind.MethodArgumentNotValidException{
        
        
        ResponseBodyObj<Diagnosis> res = new ResponseBodyObj<>(HttpStatus.OK, "Diagnosis creatded succefully",  diagnosisService.addDiagnosis(diagnosis));
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    


    @LogThis
    @GetMapping(value = {"","/"})
    public ResponseEntity<ResponseBodyObj<List<Diagnosis>>> getAllDiagnosiss(){
        ResponseBodyObj<List<Diagnosis>> res = new ResponseBodyObj<>(HttpStatus.OK, "List Of Diagnosiss",  diagnosisService.getAllDiagnosiss());
        return new ResponseEntity<>(res,HttpStatus.OK);
       
    }


    @LogThis
    @GetMapping("/{id}")
    public ResponseEntity<ResponseBodyObj<Diagnosis>> getDiagnosisById(@PathVariable int id ){
        
        ResponseBodyObj<Diagnosis> res = new ResponseBodyObj<>(HttpStatus.OK, "Requested Diagnosis ",  diagnosisService.getDiagnosisById(id));
        return new ResponseEntity<>(res,HttpStatus.OK);
        
    }


    @LogThis
    @PutMapping("/{id}")
    public ResponseEntity<ResponseBodyObj<Diagnosis>> updateDiagnosis(@RequestBody Diagnosis diagnosis,@PathVariable int id){
        
        ResponseBodyObj<Diagnosis> res = new ResponseBodyObj<>(HttpStatus.OK, "Updated Diagnosiss",  diagnosisService.updateDiagnosisById(id,diagnosis));
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @LogThis
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBodyObj<Diagnosis>> deleteDiagnosis(@PathVariable int id){
        

        ResponseBodyObj<Diagnosis> res = new ResponseBodyObj<>(HttpStatus.OK, "Deleted Diagnosiss",  diagnosisService.deleteDiagnosisById(id));
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    
 
    
    
}
