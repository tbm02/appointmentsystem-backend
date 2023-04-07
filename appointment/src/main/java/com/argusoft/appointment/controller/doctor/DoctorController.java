package com.argusoft.appointment.controller.doctor;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.argusoft.appointment.entity.Doctor;
import com.argusoft.appointment.service.doctor.DoctorService;
import com.argusoft.appointment.utils.customannotations.LogThis;
import com.argusoft.appointment.utils.request.LoginRequest;
import com.argusoft.appointment.utils.responsebody.ResponseBodyObj;
import com.argusoft.appointment.utils.responsebody.ResponseError;
import com.argusoft.appointment.utils.responsebody.UnAuthenticatedException;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;


    @LogThis
    @PostMapping(value = {"","/"})
    public ResponseEntity<ResponseBodyObj> signUpDoctor(@RequestBody Doctor doctor){
        
        
        ResponseBodyObj<Doctor> res = new ResponseBodyObj(HttpStatus.OK, "Doctor creatded succefully", (Doctor) doctorService.signUpDoctor(doctor));
        return new ResponseEntity<ResponseBodyObj>(res,HttpStatus.OK);
    }

    @LogThis
    @PostMapping(value = {"/login","/login/"})
    public ResponseEntity<ResponseBodyObj> loginDoctor(@RequestBody LoginRequest<String,String> doctor) throws UnAuthenticatedException{
        
        Doctor u = doctorService.authenticateDoctor(doctor.getEmail(),doctor.getPassword());
        ResponseBodyObj<Doctor> res = new ResponseBodyObj<>(HttpStatus.OK, "Authenticated Success",u);
        
        return new ResponseEntity<>(res,HttpStatus.OK);
    }


    @LogThis
    @GetMapping(value = {"","/"})
    public List<Doctor> getAllDoctors(){
        
        return doctorService.getAllDoctors();
    }


    @LogThis
    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable int id ){
        
        
        return doctorService.getDoctorById(id);
    }


    @LogThis
    @PutMapping("/{id}")
    public Doctor updateDoctor(@RequestBody Doctor doctor,@PathVariable int id){
        
        return doctorService.updateDoctorById(id,doctor);
    }

    @LogThis
    @DeleteMapping("/{id}")
    public Doctor deleteDoctor(@PathVariable int id){
        

        return doctorService.deleteDoctorById(id);
    }
    public DoctorController(){

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
