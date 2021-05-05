package com.project.service.impl;

import com.project.dao.api.TrainDAO;
import com.project.dto.TrainDTO;
import com.project.service.api.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainServiceImpl implements TrainService {

    @Autowired
    private TrainDAO trainDAO;

    @Override
    public TrainDTO findTrain(int trainNumber) {
        return trainDAO.findTrain(trainNumber);
    }

    @Override
    public List<TrainDTO> findAllTrains() {
        return trainDAO.findAllTrains();
    }

    @Override
    public void createTrain(int trainNumber, int numPlaces) {
        TrainDTO trainDTO = new TrainDTO(trainNumber, numPlaces);
        trainDAO.createTrain(trainDTO);
    }

    // returns deleted train number or 0 if train not found
    @Override
    public int deleteTrain(int trainNumber) {
        TrainDTO trainDTO = new TrainDTO();
        trainDTO.setTrainNumber(trainNumber);
        return trainDAO.deleteTrain(trainDTO) == 1 ? trainNumber : 0;
    }

    @Override
    public void updateTrain(int trainNumber, int numPlaces) {
        TrainDTO trainDTO = new TrainDTO();
        trainDTO.setTrainNumber(trainNumber);
        trainDTO.setNumPlaces(numPlaces);
        trainDAO.updateTrain(trainDTO);
    }
}
