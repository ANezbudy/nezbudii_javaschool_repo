package com.project.dao.api;


import com.project.entity.Passenger;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface PassengerDAO {
    Passenger findPassenger(String passengerName, String passengerLastName);
    Passenger findPassengerByID(int id);

    List<Passenger> findAllPassengers();

    void createPassenger(String passengerName, String passengerLastName);

    int deletePassenger(String passengerName, String passengerLastName);

    int deletePassengerById(int id);

    void updatePassenger(int id, String name, String lastName);
}
