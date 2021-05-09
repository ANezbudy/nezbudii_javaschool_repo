package com.project.service.api;


import com.project.dto.PassengerDTO;

import java.util.List;

public interface PassengerService {
    PassengerDTO findPassengerByID(int id);

    List<PassengerDTO> findAllPassengers();

    void createPassenger(PassengerDTO passengerDTO);

    int deletePassengerById(PassengerDTO passengerDTO);

    void updatePassenger(PassengerDTO passengerDTO);
}
