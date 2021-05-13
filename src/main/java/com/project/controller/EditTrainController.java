package com.project.controller;

import com.project.dto.TrainDTO;
import com.project.service.api.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class EditTrainController {

    @Autowired
    private TrainService trainService;

    @Autowired
    private TrainController trainController;

    @RequestMapping("/submitedittrain")
    public ModelAndView edit(HttpServletRequest request){
        TrainDTO trainDTO = new TrainDTO();
        trainDTO.setTrainNumber(request.getParameter("trainNumber"));
        trainDTO.setNumPlaces(request.getParameter("numPlaces"));
        trainService.updateTrain(trainDTO);
        return trainController.allTrains();
    }
}
