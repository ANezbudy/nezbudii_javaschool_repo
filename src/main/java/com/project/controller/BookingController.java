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
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    public ModelAndView initBooking(HttpServletRequest request, HttpSession session) {
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setTrainNumber(request.getParameter("trainNumber"));
        bookingDTO.setStationName(request.getParameter("departureStationName"));
        bookingDTO.setScheduleId(request.getParameter("scheduleId"));

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        try {
            Date departureTime = format.parse(request.getParameter("departureTime"));
            //some madness aaaaa!!!
            session.setAttribute("departureTime", departureTime);
            bookingDTO.setDepartureTime(departureTime);
        } catch (ParseException exception) {
            //TODO add logging
            exception.printStackTrace();
        }


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("buyticket");
        modelAndView.addObject("bookingDTO", bookingDTO);
        return modelAndView;
    }

    @RequestMapping("/bookTicket")
    public ModelAndView bookTicket(HttpServletRequest request, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("bookingresult");

        String  trainNumber = request.getParameter("trainNumber");
        String scheduleId = request.getParameter("scheduleId");
        String stationName = request.getParameter("stationName");

        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setPassengerName(request.getParameter("passengerName"));
        bookingDTO.setPassengerLastName(request.getParameter("passengerLastName"));
        bookingDTO.setPassengerBirthDate(request.getParameter("passengerBirthDate"));

        Date departureTime = (Date) session.getAttribute("departureTime");
        bookingDTO.setDepartureTime(departureTime);

        bookingDTO.setTrainNumber(trainNumber);
        bookingDTO.setScheduleId(scheduleId);
        bookingDTO.setStationName(stationName);

        ResultDTO resultDTO = new ResultDTO();

        resultDTO.setMessage(bookingService.bookTicket(bookingDTO));
        resultDTO.setStationName(stationName);
        resultDTO.setTrainNumber(trainNumber);
        resultDTO.setDepartureTime(bookingDTO.getDepartureTime());

        modelAndView.addObject("resultDTO", resultDTO);
        return modelAndView;
    }

}
