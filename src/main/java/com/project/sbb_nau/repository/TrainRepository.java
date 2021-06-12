package com.project.sbb_nau.repository;

import com.project.sbb_nau.entity.Schedule;
import com.project.sbb_nau.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainRepository extends JpaRepository<Train, Integer> {
    List<Schedule> findShedulesByTrainNumber(int trainNumber);
}
