package com.project.service;

import com.project.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
@Transactional
public class PersonServiceImpl implements PersonService{

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public Person findPerson(int personID) {
        Person person = entityManager.find(Person.class, personID);

        if (person != null) {
            entityManager.detach(person);
        }

        return person;
    }
}
