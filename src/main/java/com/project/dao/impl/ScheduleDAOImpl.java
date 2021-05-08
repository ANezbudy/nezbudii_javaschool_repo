package com.project.dao.impl;

import com.project.dao.api.ScheduleDAO;
import com.project.dto.ScheduleDTO;
import com.project.entity.Schedule;
import com.project.utils.ScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ScheduleDAOImpl implements ScheduleDAO {
    @PersistenceContext
    protected EntityManager entityManager;

    @Autowired
    private ScheduleMapper scheduleMapper;

    @Override
    public ScheduleDTO findSchedule(int id) {
        Schedule schedule = entityManager.find(Schedule.class, id);

        if(schedule != null) {
            entityManager.detach(schedule);
        }
        return scheduleMapper.toDto(schedule);
    }

    @Override
    public List<ScheduleDTO> findAllSchedules() {
        List<Schedule> schedules = entityManager.createQuery("FROM Schedule").getResultList();
        return schedules.stream().map(scheduleMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public int deleteScheduleById(ScheduleDTO scheduleDTO) {
        Schedule schedule = entityManager.find(Schedule.class, scheduleDTO.getId());
        if (schedule != null) {
            entityManager.remove(schedule);
            return 1;
        }
        return 0;
    }

    @Override
    public void updateSchedule(ScheduleDTO scheduleDTO) {
        Schedule schedule = entityManager.find(Schedule.class, scheduleDTO.getId());
        entityManager.detach(schedule);
        schedule = scheduleMapper.toEntity(scheduleDTO);
        entityManager.merge(schedule);
    }
}
