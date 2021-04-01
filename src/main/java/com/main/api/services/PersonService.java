package com.main.api.services;

import java.util.List;

import com.main.api.dao.*;
import com.main.api.entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepo;

    public Person getPersonById(Long personId) {
        return personRepo.getPersonById(personId);
    }

    public List<Person> getPersonByName(String firstName, String lastName) {
        return personRepo.getPersonByName(firstName, lastName);
    }

    public List<Person> getAllPersons() {
        return personRepo.getAll();
    }

    public void addPerson(Person person) {
        personRepo.create(person);
    }

    public void updatePerson(Person person) {
        personRepo.update(person);
    }

    public void deletePerson(Long personId) {
        personRepo.delete(personId);
    }

}