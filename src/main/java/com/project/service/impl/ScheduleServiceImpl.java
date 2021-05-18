package com.project.service.impl;

import com.project.dao.api.ScheduleDAO;
import com.project.dao.api.StationDAO;
import com.project.dao.api.TrainDAO;
import com.project.dto.ScheduleDTO;
import com.project.dto.StationDTO;
import com.project.entity.Schedule;
import com.project.service.api.ScheduleService;
import com.project.utils.ScheduleMapper;
import com.project.utils.StationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleDAO scheduleDAO;

    @Autowired
    private StationDAO stationDAO;

    @Autowired
    private TrainDAO trainDAO;

    @Autowired
    private ScheduleMapper scheduleMapper;

    @Autowired
    private StationMapper stationMapper;

    @Override
    public ScheduleDTO findSchedule(ScheduleDTO scheduleDTO) {
        Schedule schedule = scheduleDAO.findSchedule(scheduleDTO.getId());
        ScheduleDTO scheduleDTO1 = new ScheduleDTO();
        scheduleDTO1.setId(schedule.getId());
        scheduleDTO1.setTrain(schedule.getTrain());
        scheduleDTO1.setStationId(schedule.getStation().getId());
        scheduleDTO1.setTrainNumber(schedule.getTrain().getTrainNumber());
        scheduleDTO1.setArrivalTime(schedule.getArrivalTime());
        scheduleDTO1.setDepartureTime(schedule.getDepartureTime());

        return scheduleDTO1;
    }

    @Override
    public List<ScheduleDTO> findAllSchedules() {
        return scheduleDAO.findAllSchedules().stream().map(s -> scheduleMapper.toDto(s)).collect(Collectors.toList());
    }

    @Override
    public List<ScheduleDTO> findStationSchedules(StationDTO stationDTO) {

        return scheduleDAO.findStationSchedule(stationMapper.toEntity(stationDTO)).stream()
                .map(s -> {
                    ScheduleDTO scheduleDTO = new ScheduleDTO();
                    scheduleDTO.setId(s.getId());
                    scheduleDTO.setTrain(s.getTrain());
                    scheduleDTO.setStationId(s.getStation().getId());
                    scheduleDTO.setTrainNumber(s.getTrain().getTrainNumber());
                    scheduleDTO.setArrivalTime(s.getArrivalTime());
                    scheduleDTO.setDepartureTime(s.getDepartureTime());
                    return scheduleDTO;
                }).collect(Collectors.toList());
    }

    @Override
    public int deleteSchedule(ScheduleDTO scheduleDTO) {
        return scheduleDAO.deleteSchedule(scheduleDTO.getId());
    }

    //TODO use mapper to pass the entity
    @Override
    public void updateSchedule(ScheduleDTO scheduleDTO) {
        Schedule schedule = new Schedule();
        schedule.setId(scheduleDTO.getId());
        schedule.setStation(stationDAO.findStation(scheduleDTO.getStationId()));
        schedule.setTrain(trainDAO.findTrain(scheduleDTO.getTrainNumber()));
        schedule.setDepartureTime(scheduleDTO.getDepartureTime());
        schedule.setArrivalTime(scheduleDTO.getArrivalTime());
        scheduleDAO.updateSchedule(schedule);
    }

    @Override
    public void createSchedule(ScheduleDTO scheduleDTO) {

        Schedule schedule = new Schedule();
        schedule.setStation(stationDAO.findStation(scheduleDTO.getStationId()));
        schedule.setTrain(trainDAO.findTrain(scheduleDTO.getTrainNumber()));
        schedule.setDepartureTime(scheduleDTO.getDepartureTime());
        schedule.setArrivalTime(scheduleDTO.getArrivalTime());

        scheduleDAO.createSchedule(schedule);
    }
}
