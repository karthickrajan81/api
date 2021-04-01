package com.main.api.controllers;

import java.util.List;

import com.main.api.entities.Person;
import com.main.api.services.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/")
    public String person() throws Exception {
        return "Welcome to Person Controller!";
    }

    @GetMapping("/{id}")
    public Person getPersonbyId(@PathVariable Long id) throws Exception {
        return personService.getPersonById(id);
    }

    @GetMapping("/")
    public List<Person> getPersonbyName(@RequestBody Person person) throws Exception {
        return personService.getPersonByName(person.getFirstName(), person.getLastName());
    }

    @GetMapping("/all")
    public List<Person> getAllPerson() throws Exception {
        return personService.getAllPersons();
    }

    @PostMapping("/add")
    public void AddPerson(@RequestBody Person person) throws Exception {
        personService.addPerson(person);
    }

    @PutMapping("/update")
    public void updatePerson(@RequestBody Person person) throws Exception {
        personService.updatePerson(person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) throws Exception {
        personService.deletePerson(id);
    }
}
