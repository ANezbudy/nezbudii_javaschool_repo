package com.project.dao.api;

import com.project.entity.Schedule;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ScheduleDAO {
    Schedule findSchedule(int id);

    List<Schedule> findAllSchedules();

    List<Schedule> findStationSchedule(int stationId);

    int deleteSchedule(int scheduleId);

    void updateSchedule(Schedule schedule);

    void createSchedule(Schedule schedule);
}
