package com.project.service;

import com.project.dao.PersonDAO;
import com.project.dao.PersonDAOImpl;
import com.project.entity.Person;

import javax.transaction.Transactional;
import java.util.List;

public class PersonServiceImpl implements PersonService{
    private PersonDAO personDAO = new PersonDAOImpl();

    @Override
    @Transactional
    public List<Person> allPersons() {

       return personDAO.allPersons();
    }
}
