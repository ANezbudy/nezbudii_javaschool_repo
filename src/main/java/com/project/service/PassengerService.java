package com.project.service;

import com.project.entity.Passenger;

import java.util.List;

public interface PassengerService {
    Passenger findPassenger(int personID);

    List<Passenger> findAllPassengers();

    void createPassenger(String name);

    String deletePassenger(int id);

    void updatePassenger(int id, String newName);
}
