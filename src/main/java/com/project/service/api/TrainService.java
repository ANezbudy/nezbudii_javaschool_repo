package com.project.service.api;

import com.project.dto.TrainDTO;

import java.util.List;

public interface TrainService {
    TrainDTO findTrain(TrainDTO trainDTO);

    List<TrainDTO> findAllTrains();

    void createTrain(TrainDTO trainDTO);

    int deleteTrain(TrainDTO trainDTO);

    void updateTrain(TrainDTO trainDTO);
}
