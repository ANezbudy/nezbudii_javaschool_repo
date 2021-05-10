package com.project.service.impl;

import com.project.dao.api.ScheduleDAO;
import com.project.dto.ScheduleDTO;
import com.project.dto.StationDTO;
import com.project.service.api.ScheduleService;
import com.project.utils.ScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleDAO scheduleDAO;

    @Autowired
    private ScheduleMapper scheduleMapper;

    @Override
    public ScheduleDTO findSchedule(ScheduleDTO scheduleDTO) {
        return scheduleMapper.toDto(scheduleDAO.findSchedule(scheduleDTO.getId()));
    }

    @Override
    public List<ScheduleDTO> findAllSchedules() {
        return scheduleDAO.findAllSchedules().stream().map(s -> scheduleMapper.toDto(s)).collect(Collectors.toList());
    }

    @Override
    public List<ScheduleDTO> findStationSchedules(StationDTO stationDTO) {
        return scheduleDAO.findStationSchedule(stationDTO.getId()).stream()
                .map(s -> scheduleMapper.toDto(s)).collect(Collectors.toList());
    }

    @Override
    public int deleteScheduleById(ScheduleDTO scheduleDTO) {
        return 0;
    }

    @Override
    public void updateSchedule(ScheduleDTO scheduleDTO) {
        scheduleDAO.updateSchedule(
                scheduleDTO.getId(),
                scheduleDTO.getTrainNumber(),
                scheduleDTO.getStationId(),
                scheduleDTO.getTime()
        );
    }
}
