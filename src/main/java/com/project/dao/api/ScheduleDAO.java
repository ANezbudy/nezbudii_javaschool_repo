package com.project.dao.api;

import com.project.entity.Schedule;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Transactional
public interface ScheduleDAO {
    Schedule findSchedule(int id);

    List<Schedule> findAllSchedules();

    List<Schedule> findStationSchedule(int stationId);

    int deleteScheduleById(int scheduleId);

    void updateSchedule(int scheduleId, int trainNumber, int stationId, Date time);
}
