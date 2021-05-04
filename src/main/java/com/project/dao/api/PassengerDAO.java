package com.project.dao.api;


import com.project.dto.PassengerDTO;
import com.project.entity.Passenger;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
@Transactional
public interface PassengerDAO {
//    PassengerDTO findPassenger(String passengerName, String passengerLastName);
    PassengerDTO findPassengerByID(int id);

    List<PassengerDTO> findAllPassengers();

    void createPassenger(String passengerName, String passengerLastName, String passengerBirthDate);

    // why returns int??
    int deletePassengerById(int id);

    void updatePassenger(int id, String passengerName, String passengerLastName, String passengerBirthDate);
}
