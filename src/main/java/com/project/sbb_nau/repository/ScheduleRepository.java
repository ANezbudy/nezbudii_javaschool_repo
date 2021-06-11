package com.project.sbb_nau.repository;

import com.project.sbb_nau.entity.Schedule;
import com.project.sbb_nau.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<UserEntity, Integer> {
    List<Schedule> findByTrainNumber(int trainNumber);
}
