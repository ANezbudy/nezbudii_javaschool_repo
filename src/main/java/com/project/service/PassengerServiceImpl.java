package com.project.service;

import com.project.dao.PassengerDAO;
import com.project.dao.PassengerDAOImpl;
import com.project.entity.Passenger;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService{
    private PassengerDAO passengerDAO = new PassengerDAOImpl();

    @Override
    public Passenger findPassenger(int personID) {
        return passengerDAO.findPassenger(personID);
    }

    @Override
    public List<Passenger> findAllPassengers() {
        return passengerDAO.findAllPassengers();
    }

    @Override
    public void createPassenger(String name) {
        passengerDAO.createPassenger(name);
    }

    @Override
    public String deletePassenger(int id) {
        return passengerDAO.deletePassenger(id);
    }

    @Override
    public void updatePassenger(int id, String newName) {
        passengerDAO.updatePassenger(id, newName);
    }
}
