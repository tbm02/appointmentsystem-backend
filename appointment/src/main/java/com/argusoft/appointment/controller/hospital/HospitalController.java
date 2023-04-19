package com.argusoft.appointment.controller.hospital;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.argusoft.appointment.entity.Hospital;
import com.argusoft.appointment.service.hospital.HospitalService;
import com.argusoft.appointment.utils.customannotations.LogThis;
import com.argusoft.appointment.utils.responsebody.ResponseBodyObj;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/hospital")
@CrossOrigin("http://localhost:4200")
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;


    @LogThis
    @PostMapping(value = {"","/"})
    public ResponseEntity<ResponseBodyObj<Hospital>> addNewHospital(@RequestBody @Valid Hospital hospital){
        
        
        ResponseBodyObj<Hospital> res = new ResponseBodyObj<>(HttpStatus.OK, "Hospital creatded succefully",  hospitalService.signUpHospital(hospital));
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    


    @LogThis
    @GetMapping(value = {"","/"})
    public ResponseEntity<ResponseBodyObj<List<Hospital>>> getAllHospitals(){
        ResponseBodyObj<List<Hospital>> res = new ResponseBodyObj<>(HttpStatus.OK, "List Of Hospitals",  hospitalService.getAllHospitals());
        return new ResponseEntity<>(res,HttpStatus.OK);
    }


    @LogThis
    @GetMapping("/{id}")
    public ResponseEntity<ResponseBodyObj<Hospital>> getHospitalById(@PathVariable int id ){
        
        
        ResponseBodyObj<Hospital> res = new ResponseBodyObj<>(HttpStatus.OK, "Requsted Hospital",  hospitalService.getHospitalById(id));
        return new ResponseEntity<>(res,HttpStatus.OK);
    }


    @LogThis
    @PutMapping("/{id}")
    public ResponseEntity<ResponseBodyObj<Hospital>> updateHospital(@RequestBody @Valid Hospital hospital,@PathVariable int id){
        
        ResponseBodyObj<Hospital> res = new ResponseBodyObj<>(HttpStatus.OK, "Updated Hospital",  hospitalService.updateHospitalById(id,hospital));
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @LogThis
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBodyObj<Hospital>> deleteHospital(@PathVariable int id){
        

        ResponseBodyObj<Hospital> res = new ResponseBodyObj<>(HttpStatus.OK, "Deleted Hospital",  hospitalService.deleteHospitalById(id));
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
   
   
}
