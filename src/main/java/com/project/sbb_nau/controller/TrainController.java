package com.project.sbb_nau.controller;

import com.project.sbb_nau.config.dto.TrainDto;
import com.project.sbb_nau.entity.Train;
import com.project.sbb_nau.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:8081")
public class TrainController {
    @Autowired
    TrainService trainService;

    @GetMapping("/trains")
    public List<Train> listAllTrains() {
        return trainService.listAllTrains();
    }

    @PostMapping("/trains/create")
    public String createTrain(@RequestBody TrainDto trainDto) {
        Train train = new Train();
        train.setTrainNumber(trainDto.getTrainNumber());
        train.setNumPlaces(trainDto.getNumPlaces());
        train.setEmptyPlaces(trainDto.getNumPlaces());
        trainService.saveTrain(train);
        return "Train created";
    }

    @PutMapping("/train/update")
    public String updateTrain(@RequestBody TrainDto trainDto) {
        Train train = trainService.getTrainById(trainDto.getId());
        train.setTrainNumber(trainDto.getTrainNumber());
        train.setNumPlaces(trainDto.getNumPlaces());
        //TODO provide validation for emptyPlaces < numPlaces
        train.setEmptyPlaces(trainDto.getEmptyPlaces());
        trainService.saveTrain(train);
        return "Train updated";
    }

    @DeleteMapping("/train/delete")
    public String deleteTrain(@RequestBody TrainDto trainDto) {
        trainService.deleteTrain(trainDto.getId());
        return "Train deleted";
    }

}
