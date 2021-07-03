package com.project.sbb_nau.service.implementation;

import com.project.sbb_nau.entity.Train;
import com.project.sbb_nau.repository.TrainRepository;
import com.project.sbb_nau.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TrainServiceImpl implements TrainService {
    @Autowired
    private TrainRepository trainRepository;

    @Override
    public List<Train> listAllTrains() {
        return trainRepository.findAll();
    }

    //TODO provide exception handling
    @Override
    public void saveTrain(Train train) {
        if (train.getEmptyPlaces() <= train.getNumPlaces()) {
            trainRepository.save(train);
        } else {
            throw new IllegalArgumentException("The number of empty places can't be bigger then number of places");
        }

    }

    //TODO manage the exception from get
    @Override
    public Train getTrainById(Integer id) {
        return trainRepository.findById(id).get();
    }

    @Override
    public Train getTrainByTrainNumber(int trainNumber) {
        return trainRepository.findByTrainNumber(trainNumber);
    }

    @Override
    public void deleteTrain(Integer trainNumber) {
        trainRepository.deleteById(trainNumber);
    }

}
