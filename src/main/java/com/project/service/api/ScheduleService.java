package com.project.service.api;

import com.project.dto.ScheduleDTO;
import com.project.dto.StationDTO;

import java.util.List;

public interface ScheduleService {
    ScheduleDTO findSchedule(ScheduleDTO scheduleDTO);

    List<ScheduleDTO> findAllSchedules();

    List<ScheduleDTO> findStationSchedules(StationDTO stationDTO);

    int deleteSchedule(ScheduleDTO scheduleDTO);

    void updateSchedule(ScheduleDTO scheduleDTO);

    void createSchedule(ScheduleDTO scheduleDTO);
}
