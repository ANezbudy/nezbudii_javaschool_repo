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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/")
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

    // handle exceptions and move somewhere better place
    @RequestMapping("/submitpassenger")
    public RedirectView submit(HttpServletRequest request) throws ParseException {
        String passengerName = request.getParameter("passengerName");
        String passengerLastName = request.getParameter("passengerLastName");
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date passengerBithDate = format.parse(request.getParameter("passengerBirthDate"));
        passengerService.createPassenger(passengerName, passengerLastName, passengerBithDate);
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
    public ModelAndView openEditForm(HttpServletRequest request) {
        String passengerId = request.getParameter("passengerID");
        int id = Integer.parseInt(passengerId);
        Passenger passenger = passengerService.findPassengerByID(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit");
        modelAndView.addObject("passenger", passenger);
        return modelAndView;
    }
}
