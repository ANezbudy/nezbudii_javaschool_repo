package com.project.service.impl;

import com.project.dao.api.PassengerDAO;
import com.project.dao.impl.PassengerDAOImpl;
import com.project.entity.Passenger;
import com.project.service.api.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerDAO passengerDAO;

    @Override
    public Passenger findPassenger(String passengerName, String passengerLastName) {
        return passengerDAO.findPassenger(passengerName, passengerLastName);
    }

    @Override
    public Passenger findPassengerByID(int id) {
        return passengerDAO.findPassengerByID(id);
    }

    @Override
    public List<Passenger> findAllPassengers() {
        return passengerDAO.findAllPassengers();
    }

    @Override
    public void createPassenger(String passengerName, String passengerLastName) {
        passengerDAO.createPassenger(passengerName, passengerLastName);
    }

    @Override
    public int deletePassenger(String passengerName, String passengerLastName) {
        return passengerDAO.deletePassenger(passengerName, passengerLastName);
    }

    @Override
    public int deletePassengerById(int id) {
        return passengerDAO.deletePassengerById(id);
    }

    @Override
    public void updatePassenger(int id, String name, String lastName) {
        passengerDAO.updatePassenger(id, name, lastName);
    }
}
