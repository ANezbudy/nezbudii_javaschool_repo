package com.project.dao.api;

import com.project.entity.Train;

import java.util.List;

public interface TrainDAO {

    Train findTrain(int trainNumber);

    List<Train> findAllTrains();

    void createTrain(int trainNumber, int numPlaces);

    // why returns int??
    int deleteTrain(int trainNumber);

    void updateTrain(int trainNumber, int numPlaces);
}
