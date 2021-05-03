package com.project.controller;

import com.project.entity.Train;
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
public class TrainController {
    @Autowired
    private TrainService trainService;

    @RequestMapping(value = "/trains", method = RequestMethod.GET)
    public ModelAndView allTrains() {
        List<Train> trainList = trainService.findAllTrains();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("trains");
        modelAndView.addObject("trainList", trainList);
        return modelAndView;
    }

    // handle exceptions and move somewhere better place
    @RequestMapping("/submittrain")
    public RedirectView submitTrain(HttpServletRequest request) throws ParseException {
        // handle exception???
        int trainNumber = Integer.parseInt(request.getParameter("trainNumber"));
        int numPlaces = Integer.parseInt(request.getParameter("numPlaces"));
        trainService.createTrain(trainNumber, numPlaces);
        String contextPath = request.getContextPath();
        return new RedirectView(contextPath + "/trains");
    }

    @RequestMapping("/deletetrain")
    public RedirectView deleteTrain(HttpServletRequest request) {
        int trainNumber = Integer.parseInt(request.getParameter("trainNumber"));
        trainService.deleteTrain(trainNumber);
        String contextPath = request.getContextPath();
        return new RedirectView(contextPath + "/trains");
    }

    @RequestMapping("/startedittrain")
    public ModelAndView openTrainEditForm(HttpServletRequest request) {
        int trainNumber = Integer.parseInt(request.getParameter("trainNumber"));
        Train train = trainService.findTrain(trainNumber);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edittrain");
        modelAndView.addObject("train", train);
        return modelAndView;
    }
}
