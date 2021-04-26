package com.project.dao;

import com.project.entity.Passenger;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface PassengerDAO {
    Passenger findPassenger(int passengerID);

    List<Passenger> findAllPassengers();

    void createPassenger(String name);

    String deletePassenger(int id);

    void updatePassenger(int id, String newName);
}


