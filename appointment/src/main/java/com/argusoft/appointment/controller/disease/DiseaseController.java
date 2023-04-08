package com.argusoft.appointment.controller.disease;

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

import com.argusoft.appointment.entity.Disease;
import com.argusoft.appointment.service.disease.DiseaseService;
import com.argusoft.appointment.utils.customannotations.LogThis;
import com.argusoft.appointment.utils.request.LoginRequest;
import com.argusoft.appointment.utils.responsebody.ResponseBodyObj;
import com.argusoft.appointment.utils.responsebody.ResponseError;
import com.argusoft.appointment.utils.responsebody.UnAuthenticatedException;

@RestController
@RequestMapping("/api/disease")
public class DiseaseController {

    @Autowired
    private DiseaseService diseaseService;


    @LogThis
    @PostMapping(value = {"","/"})
    public ResponseEntity<ResponseBodyObj> addDisease(@RequestBody Disease disease){
        
        
        ResponseBodyObj<Disease> res = new ResponseBodyObj(HttpStatus.OK, "Disease creatded succefully", (Disease) diseaseService.addDisease(disease));
        return new ResponseEntity<ResponseBodyObj>(res,HttpStatus.OK);
    }

    


    @LogThis
    @GetMapping(value = {"","/"})
    public List<Disease> getAllDiseases(){
        
        return diseaseService.getAllDiseases();
    }


    @LogThis
    @GetMapping("/{id}")
    public Disease getDiseaseById(@PathVariable int id ){
        
        
        return diseaseService.getDiseaseById(id);
    }


    @LogThis
    @PutMapping("/{id}")
    public Disease updateDisease(@RequestBody Disease disease,@PathVariable int id){
        
        return diseaseService.updateDiseaseById(id,disease);
    }

    @LogThis
    @DeleteMapping("/{id}")
    public Disease deleteDisease(@PathVariable int id){
        

        return diseaseService.deleteDiseaseById(id);
    }
    public DiseaseController(){

    }
    @ExceptionHandler(value = jakarta.persistence.NoResultException.class)
    public ResponseEntity<ResponseBodyObj> handleNullPointer(){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = java.sql.SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ResponseError> handleIntegrity(){
        ResponseError error = new ResponseError(HttpStatus.BAD_REQUEST, "Please match the constraunts");
                return new ResponseEntity<ResponseError>(error,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = UnAuthenticatedException.class)
    public ResponseEntity<ResponseError> handleUnathentic(){
        ResponseError error = new ResponseError(HttpStatus.UNAUTHORIZED, "You are not allowed to access");
                return new ResponseEntity<ResponseError>(error,HttpStatus.UNAUTHORIZED);
    }
    
}