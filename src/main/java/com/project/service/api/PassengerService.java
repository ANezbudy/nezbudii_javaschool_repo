package com.project.service.api;


import com.project.dto.PassengerDTO;

import java.util.List;

public interface PassengerService {
    PassengerDTO findPassenger(PassengerDTO passengerDTO);

    List<PassengerDTO> findAllPassengers();

    int createPassenger(PassengerDTO passengerDTO);

    int deletePassengerById(PassengerDTO passengerDTO);

    void updatePassenger(PassengerDTO passengerDTO);
}
