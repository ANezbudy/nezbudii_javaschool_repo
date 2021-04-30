package com.project.service.api;


import com.project.entity.Passenger;

import java.util.Date;
import java.util.List;

public interface PassengerService {
    Passenger findPassengerByID(int id);

    List<Passenger> findAllPassengers();

    void createPassenger(String passengerName, String passengerLastName, Date passengerBirthDate);


    int deletePassengerById(int id);

    void updatePassenger(int id, String passengerName, String passengerLastName, Date passengerBirthDate);
}
