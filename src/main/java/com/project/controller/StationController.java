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
        StationDTO stationDTO = new StationDTO();
        stationDTO.setId(request.getParameter("stationId"));
        StationDTO resultStationDTO = stationService.findStation(stationDTO);
        List<ScheduleDTO> scheduleDTOList = scheduleService.findStationSchedules(resultStationDTO);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("station");
        modelAndView.addObject("resultStationDTO", resultStationDTO);
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
