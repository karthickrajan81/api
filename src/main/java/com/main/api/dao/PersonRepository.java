package com.main.api.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.main.api.entities.Person;

import java.util.List;

@Repository
public class PersonRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void create(Person Person) {
        entityManager.persist(Person);
    }

    @Transactional
    public void update(Person Person) {
        entityManager.merge(Person);
    }

    @Transactional
    public void delete(Long id) {
        Person Person = getPersonById(id);
        if (Person != null) {
            entityManager.remove(Person);
        }
    }

    public Person getPersonById(Long id) {
        return entityManager.find(Person.class, id);
    }

    public List<Person> getPersonByName(String firstName, String lastName) {
        List<Person> persons = entityManager.createQuery(
                "SELECT person FROM Person person WHERE person.firstName = :fName AND person.lastName = :lName",
                Person.class).setParameter("fName", firstName).setParameter("lName", lastName).getResultList();
        return persons;
    }

    public List<Person> getAll() {
        TypedQuery<Person> query = entityManager.createQuery("SELECT person FROM Person person", Person.class);
        return query.getResultList();
    }
}