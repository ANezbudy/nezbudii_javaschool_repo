package com.project.service.api;

import com.project.entity.Train;

import java.util.List;

public interface TrainService {
    Train findTrain(int trainNumber);

    List<Train> findAllTrains();

    void createTrain(int trainNumber, int numPlaces);

    int deleteTrain(int trainNumber);

    void updateTrain(int trainNumber, int numPlaces);
}
