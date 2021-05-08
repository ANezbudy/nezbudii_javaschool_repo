package com.project.service.api;

import com.project.dto.ScheduleDTO;

import java.util.List;

public interface ScheduleService {
    ScheduleDTO findSchedule(int id);

    List<ScheduleDTO> findAllSchedules();

    List<ScheduleDTO> findStationSchedules(int stationId);

    int deleteScheduleById(ScheduleDTO scheduleDTO);

    void updateSchedule(ScheduleDTO scheduleDTO);
}
