package com.project.controller;


import com.project.dto.StationDTO;
import com.project.service.api.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class SelectController {
    @Autowired
    StationService stationService;

    @RequestMapping("/select")
    public ModelAndView shoeSelector() {
        List<StationDTO> stationDTOList = stationService.findAllStations();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("select");
        modelAndView.addObject("stationDTOList", stationDTOList);
        return modelAndView;
    }
}
