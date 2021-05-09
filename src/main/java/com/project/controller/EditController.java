package com.project.controller;

import com.project.dto.PassengerDTO;
import com.project.service.api.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

@Controller
@RequestMapping("/admin")
public class EditController {

    @Autowired
    private PassengerService passengerService;

    @Autowired
    private PassengerController passengerController;

    @RequestMapping("/submitedit")
    public ModelAndView edit(HttpServletRequest request) throws ParseException {
        PassengerDTO passengerDTO = new PassengerDTO();
        passengerDTO.setId(request.getParameter("passengerID"));
        passengerDTO.setPassengerName(request.getParameter("passengerName"));
        passengerDTO.setPassengerLastName(request.getParameter("passengerLastName"));
        passengerDTO.setPassengerBirthDate(request.getParameter("passengerBirthDate"));
        passengerService.updatePassenger(passengerDTO);
        return passengerController.allPassengers();
    }
}
