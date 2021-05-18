package com.project.controller;


import com.project.dto.BookingDTO;
import com.project.dto.ResultDTO;
import com.project.service.api.BookingService;
import com.project.service.api.SelectService;
import com.project.service.api.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class BookingController {
    @Autowired
    StationService stationService;

    @Autowired
    SelectService selectService;

    @Autowired
    BookingService bookingService;

    @RequestMapping("/initbooking")
    public ModelAndView initBooking(HttpServletRequest request) {
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setTrainNumber(request.getParameter("trainNumber"));
        bookingDTO.setStationName(request.getParameter("departureStationName"));
        bookingDTO.setScheduleId(request.getParameter("scheduleId"));

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("buyticket");
        modelAndView.addObject("bookingDTO", bookingDTO);
        return modelAndView;
    }

    @RequestMapping("/bookTicket")
    public ModelAndView bookTicket(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("bookingresult");

        String  trainNumber = request.getParameter("trainNumber");
        String scheduleId = request.getParameter("scheduleId");
        String stationName = request.getParameter("stationName");

        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setPassengerName(request.getParameter("passengerName"));
        bookingDTO.setPassengerLastName(request.getParameter("passengerLastName"));
        bookingDTO.setPassengerBirthDate(request.getParameter("passengerBirthDate"));
        bookingDTO.setTrainNumber(trainNumber);
        bookingDTO.setScheduleId(scheduleId);
        bookingDTO.setStationName(stationName);


        ResultDTO resultDTO = new ResultDTO();



        if(!bookingService.isBookReady(trainNumber, scheduleId)) {
           String message = "There is no empty places!";
           resultDTO.setMessage(message);
        } else {
            String message = bookingService.bookTheTicket(bookingDTO);
            resultDTO.setMessage(message);
        }

        modelAndView.addObject("resultDTO", resultDTO);
        return modelAndView;
    }

}
