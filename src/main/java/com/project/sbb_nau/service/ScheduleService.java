package com.project.sbb_nau.service;

import com.project.sbb_nau.entity.Schedule;

import java.util.List;

public interface ScheduleService {
    Schedule getSchedule(int id);

    List<Schedule> getSchedules();

    List<Schedule> findByStationId(int id);

    void saveSchedule(Schedule schedule, int stationId, int trainId);

    void deleteSchedule(Integer id);
}
