package com.project.controller;

import com.project.entity.Passenger;
import com.project.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AppController {
    @Autowired
    private PassengerService passengerService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allNames() {
        List<Passenger> passengersList = passengerService.findAllPassengers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sample");
        modelAndView.addObject("passengersList", passengersList);
        return modelAndView;
    }

    @RequestMapping("/submit")
    public ModelAndView submit(HttpServletRequest request) {
        String passengerName = request.getParameter("passengerName");
        passengerService.createPassenger(passengerName);
        return allNames();
    }

    @RequestMapping("/delete")
    public ModelAndView delete(HttpServletRequest request) {
        String passengerId = request.getParameter("passengerId");
        int id = Integer.parseInt(passengerId);
        passengerService.deletePassenger(id);
        return allNames();
    }

    @RequestMapping("/update")
    public ModelAndView update(HttpServletRequest request) {
        String passengerId = request.getParameter("changePassengerID");
        int id = Integer.parseInt(passengerId);
        String newPassengerName = request.getParameter("newPassengerName");
        passengerService.updatePassenger(id, newPassengerName);
        return allNames();
    }
}
