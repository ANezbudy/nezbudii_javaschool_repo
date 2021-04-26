package com.project.dao;


import com.project.entity.Passenger;

import java.util.List;

public interface PassengerDAO {
    Passenger findPassenger(String passengerName, String passengerLastName);
    Passenger findPassengerByID(int id);

    List<Passenger> findAllPassengers();

    void createPassenger(String passengerName, String passengerLastName);

    int deletePassenger(String passengerName, String passengerLastName);

    int deletePassengerById(int id);

    void updatePassenger(int id, String name, String lastName);
}
