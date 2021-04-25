package com.project.service;

import com.project.entity.Person;

import java.util.List;

public interface PersonService {
    Person findPerson(int personID);

    List<Person> findAllPersons();

    void createPerson(String name);

    String deletePerson(int id);

    void updatePerson(int id, String newName);
}
