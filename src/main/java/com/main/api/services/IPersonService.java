package com.main.api.services;

import java.util.List;

import com.main.api.entities.Person;

public interface IPersonService {

    public Person getPersonById(Long personId);

    public List<Person> getPersonByName(String firstName, String lastName);

    public List<Person> getAllPersons();

    public boolean addPerson(Person person);

    public boolean updatePerson(Person person);

    public boolean deletePerson(Long personId);

}
