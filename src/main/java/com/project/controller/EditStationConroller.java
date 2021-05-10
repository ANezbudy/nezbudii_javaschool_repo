package com.project.controller;

import com.project.dto.StationDTO;
import com.project.service.api.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class EditStationConroller {

    @Autowired
    StationService stationService;

    @Autowired
    StationController stationController;

    @RequestMapping("/stationsubmit")
    public ModelAndView submitStation(HttpServletRequest request) {
        StationDTO stationDTO = new StationDTO();
        stationDTO.setStationName(request.getParameter("stationName"));
        stationService.createStation(stationDTO);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stations");
        stationController.allStations();
        return modelAndView;
    }
}
