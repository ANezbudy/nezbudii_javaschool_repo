package com.project.service;

import com.project.entity.Person;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface PersonService {
    Person findPerson(int personID);
}
