package com.project.controller;

import com.project.entity.Person;
import com.project.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {
//    // just to show smth in a page
//    private static Person person;
//
//    static {
//        person = new Person();
//        person.setId(1);
//        person.setName("Momo");
//    }

    @Autowired
    private PersonDAO personService;



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allNames() {
//        Person person = personService.findPerson(2);
        personService.createPerson("Ololo");
        List<Person> personsList = personService.findAllPersons();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sample");
        modelAndView.addObject("personsList", personsList);
        return modelAndView;
    }
}
