package com.project.controller;

import com.project.entity.Passenger;
import com.project.service.api.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class EditController {

    @Autowired
    private PassengerService passengerService;

    @Autowired
    private PassengerController passengerController;

    @RequestMapping("/submitedit")
    public ModelAndView edit(HttpServletRequest request) {
        String passengerId = request.getParameter("passengerID");
        int id = Integer.parseInt(passengerId);
        passengerService.updatePassenger(id, request.getParameter("passengerName"), request.getParameter("passengerLastName"));
        return passengerController.allPassengers();
    }
}
