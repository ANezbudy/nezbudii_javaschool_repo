package com.project.dao.api;


import com.project.entity.Passenger;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
@Transactional
public interface PassengerDAO {
//    PassengerDTO findPassenger(String passengerName, String passengerLastName);
    Passenger findPassengerByID(int id);

    List<Passenger> findAllPassengers();

    void createPassenger(Passenger passenger);

    // why returns int??
    int deletePassengerById(int id);

    void updatePassenger(int id, String passengerName, String passengerLastName, Date passengerBirthDate);

}
