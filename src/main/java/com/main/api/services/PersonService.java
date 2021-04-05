package com.main.api.services;

import java.util.List;

import com.main.api.dao.*;
import com.main.api.entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IPersonService {

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

    public boolean addPerson(Person person) {
        try {
            personRepo.create(person);
            return true;
        } catch (Exception ex) {

            return false;
        }
    }

    public boolean updatePerson(Person person) {
        try {
            personRepo.update(person);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean deletePerson(Long personId) {
        try {
            personRepo.delete(personId);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}