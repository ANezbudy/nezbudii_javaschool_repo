package com.project.controller;

import com.project.service.api.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class EditTrainController {

    @Autowired
    private TrainService trainService;

    @Autowired
    private TrainController trainController;

    @RequestMapping("/submitedittrain")
    public ModelAndView edit(HttpServletRequest request){
        int trainNumber = Integer.parseInt(request.getParameter("trainNumber"));
        trainService.updateTrain(trainNumber, Integer.parseInt(request.getParameter("numPlaces")));
        return trainController.allTrains();
    }
}
