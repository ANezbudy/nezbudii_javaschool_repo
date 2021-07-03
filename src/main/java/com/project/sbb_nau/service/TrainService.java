package com.project.sbb_nau.service;

import com.project.sbb_nau.entity.Train;

import java.util.List;

public interface TrainService {

    public List<Train> listAllTrains();

    public void saveTrain(Train train);

    public Train getTrainById(Integer id);

    public Train getTrainByTrainNumber(int trainNumber);

    public void deleteTrain(Integer trainNumber);
}
