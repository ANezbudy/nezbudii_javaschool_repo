package com.project.sbb_nau.service;

import com.project.sbb_nau.entity.Schedule;
import com.project.sbb_nau.entity.Train;
import com.project.sbb_nau.repository.ScheduleRepository;
import com.project.sbb_nau.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TrainService {
    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    public List<Train> listAllTrains() {
        return trainRepository.findAll();
    }

    public void saveTrain(Train train) {
        trainRepository.save(train);
    }
    //TODO manage the exception from get
    public Train getTrain(Integer trainNumber) {
        return trainRepository.findById(trainNumber).get();
    }

    public void deleteTrain(Integer trainNumber) {
        trainRepository.deleteById(trainNumber);
    }

    public List<Schedule> getSchedulesForTrain(int trainNumber) {
        return scheduleRepository.findByTrainNumber(trainNumber);
    }
}
