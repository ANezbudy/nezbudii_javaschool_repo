package com.project.dao.api;

import com.project.dto.ScheduleDTO;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ScheduleDAO {
    ScheduleDTO findSchedule(int id);

    List<ScheduleDTO> findAllSchedules();

    int deleteScheduleById(ScheduleDTO scheduleDTO);

    void updateSchedule(ScheduleDTO scheduleDTO);
}
