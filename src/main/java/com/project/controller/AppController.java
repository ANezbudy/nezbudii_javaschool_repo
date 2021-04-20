package com.project.controller;

import com.project.entity.Person;
import com.project.service.PersonService;
import com.project.service.PersonServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

    private PersonService personService = new PersonServiceImpl();



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allNames() {
        List<Person> persons = personService.allPersons();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sample");
        modelAndView.addObject("personsList", persons);
        return modelAndView;
    }
}
