package com.project.service.impl;

import com.project.dao.api.TrainDAO;
import com.project.dto.TrainDTO;
import com.project.service.api.TrainService;
import com.project.utils.TrainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainServiceImpl implements TrainService {

    @Autowired
    private TrainDAO trainDAO;

    @Autowired
    private TrainMapper trainMapper;

    @Override
    public TrainDTO findTrain(int trainNumber) {
        return trainMapper.toDto(trainDAO.findTrain(trainNumber));
    }

    @Override
    public List<TrainDTO> findAllTrains() {
        return trainDAO.findAllTrains().stream().map(s -> trainMapper.toDto(s)).collect(Collectors.toList());
    }

    @Override
    public void createTrain(TrainDTO trainDTO) {
        trainDAO.createTrain(trainDTO.getTrainNumber(), trainDTO.getNumPlaces());
    }

    // returns deleted train number or 0 if train not found
    @Override
    public int deleteTrain(TrainDTO trainDTO) {
        return trainDAO.deleteTrain(trainDTO.getTrainNumber()) == 1 ? trainDTO.getTrainNumber() : 0;
    }

    @Override
    public void updateTrain(TrainDTO trainDTO) {
        trainDAO.updateTrain(trainDTO.getTrainNumber(), trainDTO.getNumPlaces());
    }
}
