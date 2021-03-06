package com.project.dao.api;

import com.project.entity.Train;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface TrainDAO {

    Train findTrain(int trainNumber);

    List<Train> findAllTrains();

    void createTrain(Train train);

    int deleteTrain(int trainNumber);

    void updateTrain(int trainNumber, int numPlaces);

    int changeEmptyPlaces(int trainNumber, int emptyPlaces);
}
