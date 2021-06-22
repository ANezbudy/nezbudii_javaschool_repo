package com.project.sbb_nau.service;

import com.project.sbb_nau.entity.Schedule;
import com.project.sbb_nau.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    public List<Schedule> findByStationId(int id) {
        return scheduleRepository.findByStationId(id);
    }
}
