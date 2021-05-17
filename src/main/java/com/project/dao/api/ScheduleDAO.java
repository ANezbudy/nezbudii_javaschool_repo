package com.project.dao.api;

import com.project.entity.Schedule;
import com.project.entity.Station;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ScheduleDAO {
    Schedule findSchedule(int id);

    List<Schedule> findAllSchedules();

    List<Schedule> findStationSchedule(Station station);

    int deleteSchedule(int scheduleId);

    void updateSchedule(Schedule schedule);

    void createSchedule(Schedule schedule);

//    List<Schedule> findTrip(Date departureTimeA, Date arrivalTimeD, int stationIdA, int stationIdB);
}
