package com.project.dao;

import com.project.entity.Person;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface PersonDAO {
    Person findPerson(int personID);

    List<Person> findAllPersons();

    void createPerson(String name);
}


