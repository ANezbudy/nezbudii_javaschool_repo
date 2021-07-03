package com.project.sbb_nau.service.implementation;

import com.project.sbb_nau.entity.Schedule;
import com.project.sbb_nau.entity.Station;
import com.project.sbb_nau.entity.Train;
import com.project.sbb_nau.repository.ScheduleRepository;
import com.project.sbb_nau.service.ScheduleService;
import com.project.sbb_nau.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    StationService stationService;

    @Autowired
    TrainServiceImpl trainService;

    @Override
    public Schedule getSchedule(int id) {
        return scheduleRepository.findById(id).get();
    }

    @Override
    public List<Schedule> getSchedules() {
        return scheduleRepository.findAll();
    }

    @Override
    public List<Schedule> findByStationId(int id) {
        return scheduleRepository.findByStationId(id);
    }

    @Override
    public void saveSchedule(Schedule schedule, int stationId, int trainId) {
        Station station = stationService.getStation(stationId);
        Train train = trainService.getTrainById(trainId);
        schedule.setStation(station);
        schedule.setTrain(train);
        scheduleRepository.save(schedule);
    }

    @Override
    public void deleteSchedule(Integer id) {
        scheduleRepository.deleteById(id);
    }
}
