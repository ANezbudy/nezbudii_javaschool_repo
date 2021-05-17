package com.project.controller;


import com.project.dto.BookingDTO;
import com.project.dto.StationDTO;
import com.project.dto.TripDTO;
import com.project.service.api.SelectService;
import com.project.service.api.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class BookingController {
    @Autowired
    StationService stationService;

    @Autowired
    SelectService selectService;

    @RequestMapping("/initbooking")
    public ModelAndView initBooking(HttpServletRequest request) {
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setTrainNumber(request.getParameter("trainNumber"));
        bookingDTO.setStationName(request.getParameter("departureStationName"));
        bookingDTO.setScheduleId(request.getParameter("scheduleId"));

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("select");
        modelAndView.addObject("stationDTOList", stationDTOList);
        return modelAndView;
    }

    @RequestMapping("/findtrip")
    public ModelAndView findTrip(HttpServletRequest request) {
        int stationAiD = Integer.parseInt(request.getParameter("stationAiD"));
        int stationBiD = Integer.parseInt(request.getParameter("stationBiD"));
        String timeOne = request.getParameter("timeOne");
        String timeTwo = request.getParameter("timeTwo");

        List<TripDTO> tripDTOList = null;
        try {
            tripDTOList = selectService.findDepartureTrainsForTrip(stationAiD, stationBiD, timeOne, timeTwo);
        } catch (ParseException exception) {
            exception.printStackTrace();
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("trip");
        modelAndView.addObject("tripDTOList", tripDTOList);
        return modelAndView;
    }
}
