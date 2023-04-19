package com.argusoft.appointment.controller.doctor;

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

import com.argusoft.appointment.entity.Doctor;
import com.argusoft.appointment.service.doctor.DoctorService;
import com.argusoft.appointment.utils.customannotations.LogThis;
import com.argusoft.appointment.utils.customexceptions.UnAuthenticatedException;
import com.argusoft.appointment.utils.request.LoginRequest;
import com.argusoft.appointment.utils.responsebody.ResponseBodyObj;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/doctor")
@CrossOrigin("http://localhost:4200")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;


    @LogThis
    @PostMapping(value = {"","/"})
    public ResponseEntity<ResponseBodyObj<Doctor>> signUpDoctor(@RequestBody @Valid Doctor doctor)
    throws DuplicateKeyException, org.springframework.web.bind.MethodArgumentNotValidException{
        
        
        ResponseBodyObj<Doctor> res = new ResponseBodyObj<>(HttpStatus.OK, "Doctor creatded succefully", doctorService.signUpDoctor(doctor));
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @LogThis
    @PostMapping(value = {"/login","/login/"})
    public ResponseEntity<ResponseBodyObj<Doctor>> loginDoctor(@RequestBody LoginRequest<String,String> doctor) throws UnAuthenticatedException{
        
        Doctor u = doctorService.authenticateDoctor(doctor.getEmail(),doctor.getPassword());
        ResponseBodyObj<Doctor> res = new ResponseBodyObj<>(HttpStatus.OK, "Authenticated Success",u);
        
        return new ResponseEntity<>(res,HttpStatus.OK);
    }


    @LogThis
    @GetMapping(value = {"","/"})
    public ResponseEntity<ResponseBodyObj<List<Doctor>>> getAllDoctors(){
        
        ResponseBodyObj<List<Doctor>> res = new ResponseBodyObj<>(HttpStatus.OK, "List Of DOctors", doctorService.getAllDoctors());
        return new ResponseEntity<>(res,HttpStatus.OK);
    }


    @LogThis
    @GetMapping("/{id}")
    public ResponseEntity<ResponseBodyObj<Doctor>> getDoctorById(@PathVariable int id ){
        ResponseBodyObj<Doctor> res = new ResponseBodyObj<>(HttpStatus.OK, "Requested Doctor", doctorService.getDoctorById(id));

        return new ResponseEntity<>(res,HttpStatus.OK);
        
    }


    @LogThis
    @PutMapping("/{id}")
    public ResponseEntity<ResponseBodyObj<Doctor>> updateDoctor(@RequestBody @Valid Doctor doctor,@PathVariable int id)
    throws  org.springframework.web.bind.MethodArgumentNotValidException{
        
        ResponseBodyObj<Doctor> res = new ResponseBodyObj<>(HttpStatus.OK, "Doctor Updated succefully", doctorService.updateDoctorById(id,doctor));

        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @LogThis
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBodyObj<Doctor>> deleteDoctor(@PathVariable int id){
        
        ResponseBodyObj<Doctor> res = new ResponseBodyObj<>(HttpStatus.OK, "Doctor removed succefully", doctorService.deleteDoctorById(id));

        return new ResponseEntity<>(res,HttpStatus.OK);
    }

   
    
    
}
