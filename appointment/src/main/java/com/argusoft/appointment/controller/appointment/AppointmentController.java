package com.argusoft.appointment.controller.appointment;

import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.argusoft.appointment.entity.Appointment;
import com.argusoft.appointment.service.appointment.AppointmentService;
import com.argusoft.appointment.utils.customannotations.LogThis;
import com.argusoft.appointment.utils.responsebody.ResponseBodyObj;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/appointment")
@CrossOrigin("http://localhost:4200/")
public class AppointmentController {
    @Autowired
    private AppointmentService AppointmentService;


    @LogThis
    @PostMapping(value = {"","/"})
    public ResponseEntity<ResponseBodyObj<Appointment>> addAppointment(@RequestBody @Valid Appointment Appointment)
    throws DuplicateKeyException, org.springframework.web.bind.MethodArgumentNotValidException{
        
        
        ResponseBodyObj<Appointment> res = new ResponseBodyObj<>(HttpStatus.OK, "Appointment creatded succefully",  AppointmentService.createNewAppointment(Appointment));
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    


    @LogThis
    @GetMapping(value = {"","/"})
    public ResponseEntity<ResponseBodyObj<List<Appointment>>> getAllAppointments(){
        ResponseBodyObj<List<Appointment>> res = new ResponseBodyObj<>(HttpStatus.OK, "List Of Appointments",  AppointmentService.getAllAppointments());
        return new ResponseEntity<>(res,HttpStatus.OK);
       
    }


    @LogThis
    @GetMapping("/{id}")
    public ResponseEntity<ResponseBodyObj<Appointment>> getAppointmentById(@PathVariable int id ){
        
        ResponseBodyObj<Appointment> res = new ResponseBodyObj<>(HttpStatus.OK, "Requested Appointment ",  AppointmentService.getAppointmentByAppointmentId(id));
        return new ResponseEntity<>(res,HttpStatus.OK);
        
    }

    // @LogThis
    // @GetMapping("/{id}")
    // public ResponseEntity<ResponseBodyObj<Appointment>> getAppointmentByAppointmentId(@PathVariable int id ){
        
    //     ResponseBodyObj<Appointment> res = new ResponseBodyObj<>(HttpStatus.OK, "Requested Appointment ",  AppointmentService.getAppointmentByAppointmentId(id));
    //     return new ResponseEntity<>(res,HttpStatus.OK);
        
    // }
    @LogThis
    @GetMapping("/hospital/{id}")
    public ResponseEntity<ResponseBodyObj<List<Appointment>>> getAppointmentByHospitalId(@PathVariable int id ){
        
        ResponseBodyObj<List<Appointment>> res = new ResponseBodyObj<>(HttpStatus.OK, "Requested Appointment ",  AppointmentService.getAppointmentByHospitalId(id));
        return new ResponseEntity<>(res,HttpStatus.OK);
        
    }
    @LogThis
    @GetMapping("/doctor/{id}")
    public ResponseEntity<ResponseBodyObj<List<Appointment>>> getAppointmentByDoctorId(@PathVariable int id ){
        
        ResponseBodyObj<List<Appointment>> res = new ResponseBodyObj<>(HttpStatus.OK, "Requested Appointment ",  AppointmentService.getAppointmentByDoctorId(id));
        return new ResponseEntity<>(res,HttpStatus.OK);
        
    }
    @LogThis
    @GetMapping("/patient/{id}")
    public ResponseEntity<ResponseBodyObj<List<Appointment>>> getAppointmentByPatientId(@PathVariable int id ){
        
        ResponseBodyObj<List<Appointment>> res = new ResponseBodyObj<>(HttpStatus.OK, "Requested Appointment ",  AppointmentService.getAppointmentByPatientId(id));
        return new ResponseEntity<>(res,HttpStatus.OK);
        
    }


    @LogThis
    @GetMapping("/person/{id}")
    public ResponseEntity<ResponseBodyObj<List<Appointment>>> getAppointmentByPersonId(@PathVariable int id ){
        
        ResponseBodyObj<List<Appointment>> res = new ResponseBodyObj<>(HttpStatus.OK, "Requested Appointment ",  AppointmentService.getAppointmentByPersonId(id));
        return new ResponseEntity<>(res,HttpStatus.OK);
        
    }

    @LogThis
    @PutMapping("/{id}")
    public ResponseEntity<ResponseBodyObj<Appointment>> updateAppointment(@RequestBody Appointment Appointment,@PathVariable int id){
        
        ResponseBodyObj<Appointment> res = new ResponseBodyObj<>(HttpStatus.OK, "Updated Appointments",  AppointmentService.updateAppointmentById(id,Appointment));
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @LogThis
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBodyObj<Appointment>> deleteAppointment(@PathVariable int id){
        

        ResponseBodyObj<Appointment> res = new ResponseBodyObj<>(HttpStatus.OK, "Deleted Appointments",  AppointmentService.deleteAppointmentById(id));
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
 

    @LogThis
    @GetMapping(value = {"query","/query"})
    public ResponseEntity<ResponseBodyObj<List<Appointment>>> getApppointmentsByQueryParams(@RequestParam Map<String,String> allParams){
        ResponseBodyObj<List<Appointment>> res = new ResponseBodyObj<>(HttpStatus.OK, "List Of Appointments",  AppointmentService.getAppointmentsByQueryParams(allParams));
        return new ResponseEntity<>(res,HttpStatus.OK);
       
    }

 
}
