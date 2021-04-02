package com.main.api.controllers;

import java.util.List;

import com.main.api.entities.Person;
import com.main.api.services.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/person")
public class PersonController {

    private static final Logger logger = LoggerFactory.getLogger(FibonacciController.class);

    @Autowired
    private PersonService personService;

    @RequestMapping("/")
    public String person() throws Exception {
        return "Welcome to Person Controller!";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonbyId(@PathVariable Long id) throws Exception {
        try {
            Person result = personService.getPersonById(id);
            var response = new ResponseEntity<Person>(result, HttpStatus.OK);
            return response;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex.fillInStackTrace());
            throw ex;
        }
    }

    @GetMapping("/name")
    public ResponseEntity<List<Person>> getPersonbyName(@RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "lastName") String lastName) throws Exception {
        try {
            List<Person> result = personService.getPersonByName(firstName, lastName);
            var response = new ResponseEntity<List<Person>>(result, HttpStatus.OK);
            return response;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex.fillInStackTrace());
            throw ex;
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Person>> getAllPerson() throws Exception {
        try {
            List<Person> result = personService.getAllPersons();
            var response = new ResponseEntity<List<Person>>(result, HttpStatus.OK);
            return response;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex.fillInStackTrace());
            throw ex;
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Boolean> AddPerson(@RequestBody Person person) throws Exception {
        try {
            Boolean result = personService.addPerson(person);
            var response = new ResponseEntity<Boolean>(result, HttpStatus.CREATED);
            return response;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex.fillInStackTrace());
            throw ex;
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Boolean> updatePerson(@RequestBody Person person) throws Exception {
        try {
            Boolean result = personService.updatePerson(person);
            var response = new ResponseEntity<Boolean>(result, HttpStatus.OK);
            return response;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex.fillInStackTrace());
            throw ex;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletePerson(@PathVariable Long id) throws Exception {
        try {
            Boolean result = personService.deletePerson(id);
            var response = new ResponseEntity<Boolean>(result, HttpStatus.OK);
            return response;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex.fillInStackTrace());
            throw ex;
        }
    }
}
