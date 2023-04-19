package com.argusoft.appointment.controller.disease;

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

import com.argusoft.appointment.entity.Disease;
import com.argusoft.appointment.service.disease.DiseaseService;
import com.argusoft.appointment.utils.customannotations.LogThis;
import com.argusoft.appointment.utils.responsebody.ResponseBodyObj;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/disease")
@CrossOrigin("http://localhost:4200")
public class DiseaseController {

    @Autowired
    private DiseaseService diseaseService;


    @LogThis
    @PostMapping(value = {"","/"})
    public ResponseEntity<ResponseBodyObj<Disease>> addDisease(@RequestBody @Valid Disease disease)
    throws DuplicateKeyException, org.springframework.web.bind.MethodArgumentNotValidException{
        
        
        ResponseBodyObj<Disease> res = new ResponseBodyObj<>(HttpStatus.OK, "Disease creatded succefully",  diseaseService.addDisease(disease));
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    


    @LogThis
    @GetMapping(value = {"","/"})
    public ResponseEntity<ResponseBodyObj<List<Disease>>> getAllDiseases(){
        ResponseBodyObj<List<Disease>> res = new ResponseBodyObj<>(HttpStatus.OK, "List Of Diseases",  diseaseService.getAllDiseases());
        return new ResponseEntity<>(res,HttpStatus.OK);
       
    }


    @LogThis
    @GetMapping("/{id}")
    public ResponseEntity<ResponseBodyObj<Disease>> getDiseaseById(@PathVariable int id ){
        
        ResponseBodyObj<Disease> res = new ResponseBodyObj<>(HttpStatus.OK, "Requested Disease ",  diseaseService.getDiseaseById(id));
        return new ResponseEntity<>(res,HttpStatus.OK);
        
    }


    @LogThis
    @PutMapping("/{id}")
    public ResponseEntity<ResponseBodyObj<Disease>> updateDisease(@RequestBody Disease disease,@PathVariable int id){
        
        ResponseBodyObj<Disease> res = new ResponseBodyObj<>(HttpStatus.OK, "Updated Diseases",  diseaseService.updateDiseaseById(id,disease));
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @LogThis
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBodyObj<Disease>> deleteDisease(@PathVariable int id){
        

        ResponseBodyObj<Disease> res = new ResponseBodyObj<>(HttpStatus.OK, "Deleted Diseases",  diseaseService.deleteDiseaseById(id));
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
 
    
    
}
