package com.project.service.impl;

import com.project.dao.api.ScheduleDAO;
import com.project.dto.ScheduleDTO;
import com.project.service.api.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleDAO scheduleDAO;

    @Override
    public ScheduleDTO findSchedule(int id) {

        return null;
    }

    @Override
    public List<ScheduleDTO> findAllSchedules() {
        return scheduleDAO.findAllSchedules();
    }

    @Override
    public List<ScheduleDTO> findStationSchedules(int stationId) {
        List<ScheduleDTO> scheduleDTOList = findAllSchedules();
        return scheduleDTOList.stream().filter(dto -> dto.getStationId() == stationId).collect(Collectors.toList());
    }

    @Override
    public int deleteScheduleById(ScheduleDTO scheduleDTO) {
        return 0;
    }

    @Override
    public void updateSchedule(ScheduleDTO scheduleDTO) {
        scheduleDAO.updateSchedule(scheduleDTO);
    }
}
