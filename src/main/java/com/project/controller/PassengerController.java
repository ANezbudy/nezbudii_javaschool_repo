package com.project.controller;

import com.project.dto.PassengerDTO;
import com.project.service.api.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    @RequestMapping(value = "/passenger")
    public ModelAndView allPassengers() {
        List<PassengerDTO> passengerList = passengerService.findAllPassengers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("passenger");
        modelAndView.addObject("passengerList", passengerList);
        return modelAndView;
    }

    // handle exceptions and move somewhere better place
    @RequestMapping("/submitpassenger")
    public RedirectView submit(HttpServletRequest request) throws ParseException {
        PassengerDTO passengerDTO = new PassengerDTO();
        passengerDTO.setPassengerName(request.getParameter("passengerName"));
        passengerDTO.setPassengerLastName(request.getParameter("passengerLastName"));
        passengerDTO.setPassengerBirthDate(request.getParameter("passengerBirthDate"));
        passengerService.createPassenger(passengerDTO);
        String contextPath = request.getContextPath();
        return new RedirectView(contextPath + "/admin/passenger");
    }

    @RequestMapping("/deletepassenger")
    public RedirectView delete(HttpServletRequest request) {
        PassengerDTO passengerDTO = new PassengerDTO();
        passengerDTO.setId(request.getParameter("passengerID"));
        passengerService.deletePassengerById(passengerDTO);
        String contextPath = request.getContextPath();
        return new RedirectView(contextPath + "/admin/passenger");
    }

    @RequestMapping("/startedit")
    public ModelAndView openEditForm(HttpServletRequest request) {
        PassengerDTO passengerDTO = new PassengerDTO();
        passengerDTO.setId(request.getParameter("passengerID"));
        PassengerDTO resultPassengerDTO = passengerService.findPassenger(passengerDTO);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit");
        modelAndView.addObject("resultPassengerDTO", resultPassengerDTO);
        return modelAndView;
    }

    @RequestMapping("/submitedit")
    public ModelAndView edit(HttpServletRequest request) throws ParseException {
        PassengerDTO passengerDTO = new PassengerDTO();
        passengerDTO.setId(request.getParameter("passengerID"));
        passengerDTO.setPassengerName(request.getParameter("passengerName"));
        passengerDTO.setPassengerLastName(request.getParameter("passengerLastName"));
        passengerDTO.setPassengerBirthDate(request.getParameter("passengerBirthDate"));
        passengerService.updatePassenger(passengerDTO);
        return allPassengers();
    }

}
