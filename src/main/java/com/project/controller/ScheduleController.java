package com.project.controller;

import com.project.dto.ScheduleDTO;
import com.project.dto.StationDTO;
import com.project.service.api.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping("/schedule")
    public ModelAndView allSchedulesForStation(HttpServletRequest request) {
        StationDTO stationDTO = new StationDTO();
        stationDTO.setId(request.getParameter("stationId"));
        List<ScheduleDTO> scheduleDTOList = scheduleService.findStationSchedules(stationDTO);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("schedule");
        modelAndView.addObject("scheduleDTOList", scheduleDTOList);
        return modelAndView;
    }
}
