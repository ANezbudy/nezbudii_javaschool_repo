package com.project.controller;

import com.project.entity.Passenger;
import com.project.service.api.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allPassengers() {
        List<Passenger> passengerList = passengerService.findAllPassengers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("passenger");
        modelAndView.addObject("passengerList", passengerList);
        return modelAndView;
    }

    @RequestMapping("/submitpassenger")
    public RedirectView submit(HttpServletRequest request) {
        String passengerName = request.getParameter("passengerName");
        String passengerLastName = request.getParameter("passengerLastName");
        passengerService.createPassenger(passengerName, passengerLastName);
        String contextPath = request.getContextPath();
        return new RedirectView(contextPath + "/");
    }

    @RequestMapping("/deletepassenger")
    public RedirectView delete(HttpServletRequest request) {
        String passengerId = request.getParameter("passengerID");
        int id = Integer.parseInt(passengerId);
        passengerService.deletePassengerById(id);
        String contextPath = request.getContextPath();
        return new RedirectView(contextPath + "/");
    }

    @RequestMapping("/startedit")
    public RedirectView openEditForm(HttpServletRequest request) {
        String passengerId = request.getParameter("passengerID");
        int id = Integer.parseInt(passengerId);
        Passenger passenger = passengerService.findPassengerByID(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit");
        modelAndView.addObject(passenger);
        String contextPath = request.getContextPath();
        return new RedirectView(contextPath + "/");
    }
}
