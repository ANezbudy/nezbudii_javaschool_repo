package com.project.dao.api;

import com.project.dto.TrainDTO;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface TrainDAO {

    TrainDTO findTrain(int trainNumber);

    List<TrainDTO> findAllTrains();

    void createTrain(TrainDTO trainDTO);

    int deleteTrain(TrainDTO trainNumber);

    void updateTrain(TrainDTO trainDTO);
}
