package com.argusoft.appointment.controller.hospital;

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

import com.argusoft.appointment.entity.Hospital;
import com.argusoft.appointment.service.hospital.HospitalService;
import com.argusoft.appointment.utils.customannotations.LogThis;
import com.argusoft.appointment.utils.customexceptions.UnAuthenticatedException;
import com.argusoft.appointment.utils.request.LoginRequest;
import com.argusoft.appointment.utils.responsebody.ResponseBodyObj;
import com.argusoft.appointment.utils.responsebody.ResponseError;

@RestController
@RequestMapping("/api/hospital")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;


    @LogThis
    @PostMapping(value = {"","/"})
    public ResponseEntity<ResponseBodyObj> signUpHospital(@RequestBody Hospital hospital){
        
        
        ResponseBodyObj<Hospital> res = new ResponseBodyObj(HttpStatus.OK, "Hospital creatded succefully", (Hospital) hospitalService.signUpHospital(hospital));
        return new ResponseEntity<ResponseBodyObj>(res,HttpStatus.OK);
    }

    @LogThis
    @PostMapping(value = {"/login","/login/"})
    public ResponseEntity<ResponseBodyObj> loginHospital(@RequestBody LoginRequest<String,String> hospital) throws UnAuthenticatedException{
        
        Hospital u = hospitalService.authenticateHospital(hospital.getEmail(),hospital.getPassword());
        ResponseBodyObj<Hospital> res = new ResponseBodyObj<>(HttpStatus.OK, "Authenticated Success",u);
        
        return new ResponseEntity<>(res,HttpStatus.OK);
    }


    @LogThis
    @GetMapping(value = {"","/"})
    public List<Hospital> getAllHospitals(){
        
        return hospitalService.getAllHospitals();
    }


    @LogThis
    @GetMapping("/{id}")
    public Hospital getHospitalById(@PathVariable int id ){
        
        
        return hospitalService.getHospitalById(id);
    }


    @LogThis
    @PutMapping("/{id}")
    public Hospital updateHospital(@RequestBody Hospital hospital,@PathVariable int id){
        
        return hospitalService.updateHospitalById(id,hospital);
    }

    @LogThis
    @DeleteMapping("/{id}")
    public Hospital deleteHospital(@PathVariable int id){
        

        return hospitalService.deleteHospitalById(id);
    }
    public HospitalController(){

    }
    
    
}
