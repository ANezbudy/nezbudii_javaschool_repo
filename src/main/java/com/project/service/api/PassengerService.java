package com.project.service.api;


import com.project.dto.PassengerDTO;
import com.project.entity.Passenger;

import java.util.Date;
import java.util.List;

public interface PassengerService {
    PassengerDTO findPassengerByID(int id);

    List<PassengerDTO> findAllPassengers();

    void createPassenger(String passengerName, String passengerLastName, String passengerBirthDate);


    int deletePassengerById(int id);

    void updatePassenger(int id, String passengerName, String passengerLastName, String passengerBirthDate);
}
