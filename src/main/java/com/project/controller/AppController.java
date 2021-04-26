package com.project.controller;

import com.project.entity.Person;
import com.project.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
        List<Person> personsList = personService.findAllPersons();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sample");
        modelAndView.addObject("personsList", personsList);
        return modelAndView;
    }
    @RequestMapping("/submit")
    public ModelAndView submit(HttpServletRequest request) {
        String personName = request.getParameter("personName");
        personService.createPerson(personName);
        return allNames();
    }

    @RequestMapping("/delete")
    public ModelAndView delete(HttpServletRequest request) {
        String personId = request.getParameter("personID");
        int id = Integer.parseInt(personId);
        personService.deletePerson(id);
        return allNames();
    }

    @RequestMapping("/update")
    public ModelAndView update(HttpServletRequest request) {
        String personId = request.getParameter("changePersonID");
        int id = Integer.parseInt(personId);
        String newPersonName = request.getParameter("newPersonName");
        personService.updatePerson(id, newPersonName);
        return allNames();
    }
}
