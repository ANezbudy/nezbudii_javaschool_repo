package com.project.service.impl;

import com.project.dao.api.PersonDAO;
import com.project.dao.impl.PersonDAOImpl;
import com.project.entity.Person;
import com.project.service.api.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
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

    @Override
    public String deletePerson(int id) {
        return personDAO.deletePerson(id);
    }

    @Override
    public void updatePerson(int id, String newName) {
        personDAO.updatePerson(id, newName);
    }
}
