package com.project.dao;

import com.project.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

public class PersonDAOImpl implements PersonDAO{
    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    @Transactional
    public Person findPerson(int personID) {
        Person person = entityManager.find(Person.class, personID);
        entityManager.detach(person);
        return person;
    }
}
