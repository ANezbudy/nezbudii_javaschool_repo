package com.project.service.api;

import com.project.dto.TrainPassengerDTO;

import java.util.List;

public interface TicketService {
    List<TrainPassengerDTO> findTrainPassengers(int trainNumber);
}
