package com.project.dao.impl;

import com.project.dao.api.PassengerDAO;
import com.project.entity.Passenger;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@ComponentScan(basePackages = "com/project/config")
public class PassengerDAOImpl implements PassengerDAO {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public Passenger findPassenger(String passengerName, String passengerLastName) {
        Passenger passenger = entityManager.find(Passenger.class, passengerName);

        if (passenger != null) {
            entityManager.detach(passenger);
        }

        return passenger;
    }

    @Override
    public Passenger findPassengerByID(int passengerId) {
        Passenger passenger = entityManager.find(Passenger.class, passengerId);

        if (passenger != null) {
            entityManager.detach(passenger);
            if (passenger.getTicket() != null) {
                entityManager.detach(passenger.getTicket());
            }
        }

        return passenger;
    }

    @Override
    public List<Passenger> findAllPassengers() {
        List<Passenger> passengers = entityManager.createQuery("FROM Passenger").getResultList();
        return passengers;
    }

    @Override
    public void createPassenger(String passengerName, String passengerLastName, Date passengerBirthDate) {
        Passenger passenger = new Passenger();
        passenger.setPassengerName(passengerName);
        passenger.setPassengerLastName(passengerLastName);
        passenger.setPassengerBirthDate(passengerBirthDate);
        entityManager.persist(passenger);
    }

    @Override
    public int deletePassengerById(int id) {
        Passenger passenger = entityManager.find(Passenger.class, id);
        if (passenger != null) {
            entityManager.remove(passenger);
            return id;
        }
        return 0;
    }

    @Override
    public void updatePassenger(int id, String passengerName, String passengerLastName, Date passengerBirthDate) {
        Passenger passenger = findPassengerByID(id);
        entityManager.detach(passenger);
        passenger.setPassengerName(passengerName);
        passenger.setPassengerLastName(passengerLastName);
        passenger.setPassengerBirthDate(passengerBirthDate);
        entityManager.merge(passenger);
    }
}
