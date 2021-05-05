package com.project.service.api;

import com.project.dto.TrainDTO;

import java.util.List;

public interface TrainService {
    TrainDTO findTrain(int trainNumber);

    List<TrainDTO> findAllTrains();

    void createTrain(int trainNumber, int numPlaces);

    int deleteTrain(int trainNumber);

    void updateTrain(int trainNumber, int numPlaces);
}
