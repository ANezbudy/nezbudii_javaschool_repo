package com.project.service.impl;

import com.project.dao.api.TrainDAO;
import com.project.entity.Train;
import com.project.service.api.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainServiceImpl implements TrainService {

    @Autowired
    private TrainDAO trainDAO;

    @Override
    public Train findTrain(int trainNumber) {
        return trainDAO.findTrain(trainNumber);
    }

    @Override
    public List<Train> findAllTrains() {
        return trainDAO.findAllTrains();
    }

    @Override
    public void createTrain(int trainNumber, int numPlaces) {
        trainDAO.createTrain(trainNumber, numPlaces);
    }

    @Override
    public int deleteTrain(int trainNumber) {
        return trainDAO.deleteTrain(trainNumber);
    }

    @Override
    public void updateTrain(int trainNumber, int numPlaces) {
        trainDAO.updateTrain(trainNumber, numPlaces);
    }
}
