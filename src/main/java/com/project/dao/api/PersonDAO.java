package com.project.dao.api;

import com.project.entity.Person;

import javax.transaction.Transactional;
import java.util.List;

public interface PersonDAO {
    Person findPerson(int personID);

    List<Person> findAllPersons();

    void createPerson(String name);

    String deletePerson(int id);

    void updatePerson(int id, String newName);
}


