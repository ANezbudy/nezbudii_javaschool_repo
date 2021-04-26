package com.project.dao;

import com.project.entity.Person;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PersonDAOImpl implements PersonDAO {

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

    @Override
    public List<Person> findAllPersons() {
        List<Person> persons = entityManager.createQuery("FROM Person").getResultList();
        return persons;
    }

    @Override
    @Transactional
    public void createPerson(String name) {
        Person person = new Person();
        person.setName(name);
        entityManager.persist(person);
    }

    @Override
    @Transactional
    public String deletePerson(int id) {
        Person person = entityManager.find(Person.class, id);
        String personName = person.getName();
        entityManager.remove(person);
        return personName;
    }

    @Override
    @Transactional
    public void updatePerson(int id, String newName) {
        Person person = findPerson(id);
        entityManager.detach(person);
        person.setName(newName);
        entityManager.merge(person);
    }
}