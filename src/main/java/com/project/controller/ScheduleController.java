package com.project.controller;

import com.project.dto.ScheduleDTO;
import com.project.dto.StationDTO;
import com.project.dto.TrainDTO;
import com.project.service.api.ScheduleService;
import com.project.service.api.StationService;
import com.project.service.api.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private StationService stationService;

    @Autowired
    private TrainService trainService;

    public ModelAndView returnScheduleForStation(String stationID) {
        //refreshing the view
        StationDTO stationDTO = new StationDTO();
        stationDTO.setId(stationID);
        StationDTO resultStationDTO = stationService.findStation(stationDTO);
        //getting the schedule for the table
        List<ScheduleDTO> scheduleDTOList = scheduleService.findStationSchedules(resultStationDTO);

        List<TrainDTO> trainDTOList = trainService.findAllTrains();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("station");
        modelAndView.addObject("resultStationDTO", resultStationDTO);
        modelAndView.addObject("scheduleDTOList", scheduleDTOList);
        modelAndView.addObject("trainDTOList", trainDTOList);
        return modelAndView;
    }

    @RequestMapping("/schedulesubmit")
    public ModelAndView scheduleCreate(@ModelAttribute ScheduleDTO scheduleDTO) {
        //prepare DTO to transfere
//        ScheduleDTO scheduleDTO = new ScheduleDTO();
//        scheduleDTO.setStationId(request.getParameter("stationId"));
//        scheduleDTO.setTrainNumber(request.getParameter("trainNumber"));
//        scheduleDTO.setArrivalTime(request.getParameter("arrivalTime"));
//        scheduleDTO.setDepartureTime(request.getParameter("departureTime"));

        //create schedule
        scheduleService.createSchedule(scheduleDTO);

//        return returnScheduleForStation(request.getParameter("stationId"));
        return returnScheduleForStation(String.valueOf(scheduleDTO.getStationId()));
    }

    @RequestMapping("/deleteschedule")
    public ModelAndView deleteSchedule(HttpServletRequest request) {
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setId(request.getParameter("scheduleID"));
        scheduleService.deleteSchedule(scheduleDTO);

        return returnScheduleForStation(request.getParameter("stationId"));
    }

    @RequestMapping("/edittrainschedule")
    public ModelAndView editTrainSchedule(HttpServletRequest request) {
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setId(request.getParameter("scheduleID"));
        ScheduleDTO resultScheduleDTO = scheduleService.findSchedule(scheduleDTO);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("schedule");
        modelAndView.addObject("resultScheduleDTO", resultScheduleDTO);
        return modelAndView;
    }

    @RequestMapping("/schduleeditsubmit")
    public ModelAndView submitScheduleEdit(@ModelAttribute ScheduleDTO scheduleDTO) {
//        ScheduleDTO scheduleDTO = new ScheduleDTO();
//        scheduleDTO.setId(request.getParameter("scheduleID"));
//        ScheduleDTO resultScheduleDTO = scheduleService.findSchedule(scheduleDTO);
//        resultScheduleDTO.setArrivalTime(request.getParameter("arrivalTime"));
//        resultScheduleDTO.setDepartureTime(request.getParameter("departureTime"));

        //create schedule

        scheduleService.updateSchedule(scheduleDTO);

//        return returnScheduleForStation(String.valueOf(resultScheduleDTO.getStationId()));
        return returnScheduleForStation(String.valueOf(scheduleDTO.getStationId()));
    }

}
