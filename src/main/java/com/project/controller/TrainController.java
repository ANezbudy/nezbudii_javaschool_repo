package com.project.controller;

import com.project.dto.TrainDTO;
import com.project.dto.TrainPassengerDTO;
import com.project.service.api.TicketService;
import com.project.service.api.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class TrainController {
    @Autowired
    private TrainService trainService;

    @Autowired
    private TicketService ticketService;

    @RequestMapping(value = "/trains", method = RequestMethod.GET)
    public ModelAndView allTrains() {
        List<TrainDTO> trainDTOList = trainService.findAllTrains();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("trains");
        modelAndView.addObject("trainDTOList", trainDTOList);
        return modelAndView;
    }

    // handle exceptions and move somewhere better place
    @RequestMapping("/submittrain")
    public RedirectView submitTrain(HttpServletRequest request) throws ParseException {
        TrainDTO trainDTO = new TrainDTO();
        trainDTO.setTrainNumber(request.getParameter("trainNumber"));
        trainDTO.setNumPlaces(request.getParameter("numPlaces"));
        trainService.createTrain(trainDTO);
        String contextPath = request.getContextPath();
        return new RedirectView(contextPath + "/admin/trains");
    }

    @RequestMapping("/deletetrain")
    public RedirectView deleteTrain(HttpServletRequest request) {
        TrainDTO trainDTO = new TrainDTO();
        trainDTO.setTrainNumber(request.getParameter("trainNumber"));
        trainService.deleteTrain(trainDTO);
        String contextPath = request.getContextPath();
        return new RedirectView(contextPath + "/admin/trains");
    }

    @RequestMapping("/startedittrain")
    public ModelAndView openTrainEditForm(HttpServletRequest request) {
        TrainDTO trainDTO = new TrainDTO();
        trainDTO.setTrainNumber(request.getParameter("trainNumber"));
        TrainDTO resultTrainDTO = trainService.findTrain(trainDTO);

        List<TrainPassengerDTO> trainPassengerDTOList = ticketService.findTrainPassengers(resultTrainDTO.getTrainNumber());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edittrain");
        modelAndView.addObject("trainDTO", resultTrainDTO);
        modelAndView.addObject("trainPassengerDTOList", trainPassengerDTOList);
        return modelAndView;
    }

    @RequestMapping("/submitedittrain")
    public ModelAndView edit(HttpServletRequest request){
        TrainDTO trainDTO = new TrainDTO();
        trainDTO.setTrainNumber(request.getParameter("trainNumber"));
        trainDTO.setNumPlaces(request.getParameter("numPlaces"));
        trainService.updateTrain(trainDTO);
        return allTrains();
    }


}
