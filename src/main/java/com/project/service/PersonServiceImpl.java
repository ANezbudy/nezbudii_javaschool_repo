package com.project.service;

import com.project.dao.PersonDAO;
import com.project.dao.PersonDAOImpl;
import com.project.entity.Person;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{
    private PersonDAO personDAO = new PersonDAOImpl();

    @Override
    public Person findPerson(int personID) {
        return personDAO.findPerson(personID);
    }

    @Override
    public List<Person> findAllPersons() {
        return personDAO.findAllPersons();
    }

    @Override
    public void createPerson(String name) {
        personDAO.createPerson(name);
    }
}
