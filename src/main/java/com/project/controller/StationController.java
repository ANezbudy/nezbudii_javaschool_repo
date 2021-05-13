package com.project.controller;

import com.project.dto.ScheduleDTO;
import com.project.dto.StationDTO;
import com.project.dto.TrainDTO;
import com.project.service.api.ScheduleService;
import com.project.service.api.StationService;
import com.project.service.api.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class StationController {
    @Autowired
    private StationService stationService;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private TrainService trainService;

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
        List<TrainDTO> trainDTOList = trainService.findAllTrains();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("station");
        modelAndView.addObject("resultStationDTO", resultStationDTO);
        modelAndView.addObject("scheduleDTOList", scheduleDTOList);
        modelAndView.addObject("trainDTOList", trainDTOList);
        return modelAndView;
    }

    @RequestMapping("/stationsubmit")
    public ModelAndView submitStation(HttpServletRequest request) {
        StationDTO stationDTO = new StationDTO();
        stationDTO.setStationName(request.getParameter("stationName"));
        stationService.createStation(stationDTO);

        return allStations();
    }

    @RequestMapping("/stationsubmitedit")
    public ModelAndView submitEditStation(HttpServletRequest request) {
        StationDTO stationDTO = new StationDTO();
        stationDTO.setStationName(request.getParameter("stationName"));
        stationDTO.setId(request.getParameter("stationId"));
        stationService.updateStation(stationDTO);
        return allStations();
    }

    @RequestMapping("/deletestation")
    public RedirectView deletStation(HttpServletRequest request) {
        StationDTO stationDTO = new StationDTO();
        stationDTO.setId(request.getParameter("stationId"));
        stationService.deleteStation(stationDTO);
        String contextPath = request.getContextPath();
        return new RedirectView(contextPath + "/admin/stations");
    }
}
