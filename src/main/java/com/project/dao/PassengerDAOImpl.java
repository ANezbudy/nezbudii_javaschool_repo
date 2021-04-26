package com.project.dao;

import com.project.entity.Passenger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
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
        }

        return passenger;
    }

    @Override
    public List<Passenger> findAllPassengers() {
        List<Passenger> passengers = entityManager.createQuery("FROM Passenger").getResultList();
        return passengers;
    }

    @Override
    public void createPassenger(String passengerName, String passengerLastName) {
        Passenger passenger = new Passenger();
        passenger.setPassengerName(passengerName);
        passenger.setPassengerLastName(passengerLastName);
        entityManager.persist(passenger);
    }

    @Override
    public int deletePassenger(String passengerName, String passengerLastName) {
        Passenger passenger = entityManager.find(Passenger.class, passengerLastName);
        int id = passenger.getId();
        entityManager.remove(passenger);
        return id;
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
    public void updatePassenger(int id, String passengerName, String passengerLastName) {
        Passenger passenger = findPassengerByID(id);
        entityManager.detach(passenger);
        passenger.setPassengerName(passengerName);
        passenger.setPassengerLastName(passengerLastName);
        entityManager.merge(passenger);
    }
}
