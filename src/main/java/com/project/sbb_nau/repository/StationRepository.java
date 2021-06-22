package com.project.sbb_nau.repository;

import com.project.sbb_nau.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends JpaRepository<Station, Integer> {
//    List<Schedule> findSchedulesById(int stationId);
}
