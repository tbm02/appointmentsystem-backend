package com.argusoft.appointment.controller.specialization;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.argusoft.appointment.entity.Specialization;
import com.argusoft.appointment.service.specialization.SpecializationService;
import com.argusoft.appointment.utils.customannotations.LogThis;
import com.argusoft.appointment.utils.responsebody.ResponseBodyObj;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/specialization")
public class SpecializationController {
    @Autowired
    private SpecializationService specializationService;


    @LogThis
    @PostMapping(value = {"","/"})
    public ResponseEntity<ResponseBodyObj<Specialization>> addSpecialization(@RequestBody @Valid Specialization specialization)
    throws DuplicateKeyException, org.springframework.web.bind.MethodArgumentNotValidException{
        
        
        ResponseBodyObj<Specialization> res = new ResponseBodyObj<>(HttpStatus.OK, "Specialization creatded succefully",  specializationService.addSpecialization(specialization));
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    


    @LogThis
    @GetMapping(value = {"","/"})
    public ResponseEntity<ResponseBodyObj<List<Specialization>>> getAllSpecializations(){
        ResponseBodyObj<List<Specialization>> res = new ResponseBodyObj<>(HttpStatus.OK, "List Of Specializations",  specializationService.getAllSpecializations());
        return new ResponseEntity<>(res,HttpStatus.OK);
       
    }


    @LogThis
    @GetMapping("/{id}")
    public ResponseEntity<ResponseBodyObj<Specialization>> getSpecializationById(@PathVariable int id ){
        
        ResponseBodyObj<Specialization> res = new ResponseBodyObj<>(HttpStatus.OK, "Requested Specialization ",  specializationService.getSpecializationById(id));
        return new ResponseEntity<>(res,HttpStatus.OK);
        
    }


    @LogThis
    @PutMapping("/{id}")
    public ResponseEntity<ResponseBodyObj<Specialization>> updateSpecialization(@RequestBody Specialization specialization,@PathVariable int id){
        
        ResponseBodyObj<Specialization> res = new ResponseBodyObj<>(HttpStatus.OK, "Updated Specializations",  specializationService.updateSpecializationById(id,specialization));
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @LogThis
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBodyObj<Specialization>> deleteSpecialization(@PathVariable int id){
        

        ResponseBodyObj<Specialization> res = new ResponseBodyObj<>(HttpStatus.OK, "Deleted Specializations",  specializationService.deleteSpecializationById(id));
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
 
}
