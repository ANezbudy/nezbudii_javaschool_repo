package com.project.sbb_nau.repository;

import com.project.sbb_nau.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    List<Schedule> findByStationId(Integer stationId);
    List<Schedule> findByTrainId(Integer trainId);
    List<Schedule> findByStationIdAndTrainId(Integer stationId, Integer trainId);
}
