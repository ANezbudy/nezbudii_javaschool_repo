package com.project.controller;


import com.project.dto.StationDTO;
import com.project.service.api.SelectService;
import com.project.service.api.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class SelectController {
    @Autowired
    StationService stationService;

    @Autowired
    SelectService selectService;

    @RequestMapping("/select")
    public ModelAndView showSelector() {
        List<StationDTO> stationDTOList = stationService.findAllStations();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("select");
        modelAndView.addObject("stationDTOList", stationDTOList);
        return modelAndView;
    }

    @RequestMapping("/findtrip")
    public void findTrip(HttpServletRequest request) {
        int stationAiD = Integer.parseInt(request.getParameter("stationAiD"));
        int stationBiD = Integer.parseInt(request.getParameter("stationBiD"));
        String departureTimeA = request.getParameter("departureTimeA");
        String arrivalTimeB = request.getParameter("arrivalTimeB");



        try {
            selectService.findTrainsForTrip(stationAiD, stationBiD, departureTimeA, arrivalTimeB);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        showSelector();
    }
}
