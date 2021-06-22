package com.project.sbb_nau.repository;

import com.project.sbb_nau.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train, Integer> {
    Train findByTrainNumber(Integer trainNumber);
}
