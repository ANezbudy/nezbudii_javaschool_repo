package com.project.dao.impl;

import com.project.dao.api.ScheduleDAO;
import com.project.entity.Schedule;
import com.project.utils.ScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ScheduleDAOImpl implements ScheduleDAO {
    @PersistenceContext
    protected EntityManager entityManager;

    @Autowired
    private ScheduleMapper scheduleMapper;

    @Override
    public Schedule findSchedule(int id) {
        Schedule schedule = entityManager.find(Schedule.class, id);

        if(schedule != null) {
            entityManager.detach(schedule);
        }
        return schedule;
    }
    //TODO implement pagination
    @Override
    public List<Schedule> findAllSchedules() {
        return entityManager.createQuery("FROM Schedule").getResultList();
    }

    @Override
    public List<Schedule> findStationSchedule(int stationId) {
        Query query = entityManager.createQuery("FROM Schedule WHERE stationId = :id");
        query.setParameter("id", stationId);
        return query.getResultList();
    }


    @Override
    public int deleteSchedule(int scheduleId) {
        Schedule schedule = entityManager.find(Schedule.class, scheduleId);
        if (schedule != null) {
            entityManager.remove(schedule);
            return 1;
        }
        return 0;
    }

    @Override
    public void updateSchedule(Schedule schedule) {
        Schedule foundSchedule = entityManager.find(Schedule.class, schedule.getId());
        entityManager.detach(foundSchedule);
        foundSchedule.setTrainNumber(schedule.getTrainNumber());
        foundSchedule.setStationId(schedule.getStationId());
        foundSchedule.setArrivalTime(schedule.getArrivalTime());
        foundSchedule.setDepartureTime(schedule.getDepartureTime());
        entityManager.merge(foundSchedule);
    }

    @Override
    public void createSchedule(Schedule schedule) {
        entityManager.persist(schedule);
    }
}
