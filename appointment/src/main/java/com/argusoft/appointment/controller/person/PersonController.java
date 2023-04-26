package com.argusoft.appointment.controller.person;

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

import com.argusoft.appointment.entity.Person;
import com.argusoft.appointment.service.person.PersonService;
import com.argusoft.appointment.utils.customannotations.LogThis;
import com.argusoft.appointment.utils.customexceptions.UnAuthenticatedException;
import com.argusoft.appointment.utils.request.LoginRequest;
import com.argusoft.appointment.utils.responsebody.ResponseBodyObj;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/person")
@CrossOrigin("http://localhost:4200")
public class PersonController {

    @Autowired
    private PersonService personService;

    @LogThis
    @PostMapping(value = { "", "/" })
    public ResponseEntity<ResponseBodyObj<Person>> signUpPerson(@RequestBody @Valid Person person)
            throws DuplicateKeyException, org.springframework.web.bind.MethodArgumentNotValidException {
        ResponseBodyObj<Person> res = new ResponseBodyObj<>(HttpStatus.OK, "Person creatded succefully",
                personService.signUpPerson(person));
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @LogThis
    @PostMapping(value = { "/login", "/login/" })
    public ResponseEntity<ResponseBodyObj<Person>> loginPerson(@RequestBody LoginRequest<String, String> person)
            throws UnAuthenticatedException {

        Person u = personService.authenticatePerson(person.getEmail(), person.getPassword());
        ResponseBodyObj<Person> res = new ResponseBodyObj<>(HttpStatus.OK, "Authenticated Success", u);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @LogThis
    @GetMapping(value = { "", "/" })
    public ResponseEntity<ResponseBodyObj<List<Person>>> getAllPersons() {

        List<Person> persons = personService.getAllPersons();
        ResponseBodyObj<List<Person>> res = new ResponseBodyObj<>(HttpStatus.OK, "Lit of Persons", persons);
        return new ResponseEntity<>(res, HttpStatus.OK);

    }

    @LogThis
    @GetMapping("/{id}")
    public ResponseEntity<ResponseBodyObj<Person>> getPersonById(@PathVariable int id) {
        Person person = personService.getPersonById(id);

        ResponseBodyObj<Person> res = new ResponseBodyObj<>(HttpStatus.OK, "Requested Person", person);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @LogThis
    @PutMapping("/{id}")
    public ResponseEntity<ResponseBodyObj<Person>> updatePerson(@RequestBody @Valid Person person, @PathVariable int id) {

        Person updatedPerson =  personService.updatePersonById(id, person);
        ResponseBodyObj<Person> res = new ResponseBodyObj<>(HttpStatus.OK, "Updated Person", updatedPerson);
        return new ResponseEntity<>(res, HttpStatus.OK);

    }

    @LogThis
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBodyObj<Person>> deletePerson(@PathVariable int id) {

        Person deletedPerson =  personService.deletePersonById(id);
        ResponseBodyObj<Person> res = new ResponseBodyObj<>(HttpStatus.OK, "Updated Person", deletedPerson);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
