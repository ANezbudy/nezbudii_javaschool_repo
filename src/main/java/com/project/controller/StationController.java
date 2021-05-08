package com.project.controller;

import com.project.dto.ScheduleDTO;
import com.project.dto.StationDTO;
import com.project.service.api.ScheduleService;
import com.project.service.api.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class StationController {
    @Autowired
    private StationService stationService;

    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping("/stations")
    public ModelAndView allStations() {
        List<StationDTO> stationDTOList = stationService.findAllStations();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stations");
        modelAndView.addObject("stationDTOList", stationDTOList);
        return modelAndView;
    }

    @RequestMapping("/stationedit")
    public ModelAndView openEditStationForm(HttpServletRequest request) {
        int stationId = Integer.parseInt(request.getParameter("stationId"));
        StationDTO stationDTO = stationService.findStation(stationId);
        List<ScheduleDTO> scheduleDTOList = scheduleService.findStationSchedules(stationId);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("station");
        modelAndView.addObject("stationDTO", stationDTO);
        modelAndView.addObject("scheduleDTOList", scheduleDTOList);
        return modelAndView;
    }

    @RequestMapping("/stationcreate")
    public ModelAndView openCreateStationForm(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("station");
        return modelAndView;
    }
}
