package com.project.service.impl;

import com.project.dao.api.PassengerDAO;
import com.project.dao.impl.PassengerDAOImpl;
import com.project.dto.PassengerDTO;
import com.project.entity.Passenger;
import com.project.service.api.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerDAO passengerDAO;

    @Override
    public PassengerDTO findPassengerByID(int id) {
        return passengerDAO.findPassengerByID(id);
    }

    @Override
    public List<PassengerDTO> findAllPassengers() {
        return passengerDAO.findAllPassengers();
    }

    @Override
    public void createPassenger(String passengerName, String passengerLastName, String passengerBirthDate) {
        passengerDAO.createPassenger(passengerName, passengerLastName, passengerBirthDate);
    }

    @Override
    public int deletePassengerById(int id) {
        return passengerDAO.deletePassengerById(id);
    }

    @Override
    public void updatePassenger(int id, String passengerName, String passengerLastName, String passengerBirthDate) {
        passengerDAO.updatePassenger(id, passengerName, passengerLastName, passengerBirthDate);
    }
}
