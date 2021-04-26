package com.project.controller;

import com.project.entity.Passenger;
import com.project.service.api.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    @RequestMapping(value = "/passenger", method = RequestMethod.GET)
    public ModelAndView allPassengers() {
        List<Passenger> passengerList = passengerService.findAllPassengers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("passenger");
        modelAndView.addObject("passengerList", passengerList);
        return modelAndView;
    }
}
