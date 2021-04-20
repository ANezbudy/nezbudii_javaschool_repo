package com.project.dao;

import com.project.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PersonDAOImpl implements PersonDAO{
    //attempt to connect to DB
    private SessionFactory sessionFactory;

    @Autowired
    public PersonDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Person> allPersons() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Person").list();
    }



}
