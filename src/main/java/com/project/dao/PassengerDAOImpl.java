package com.project.dao;

import com.project.entity.Passenger;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PassengerDAOImpl implements PassengerDAO {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public Passenger findPassenger(int passengerID) {
        Passenger passenger = entityManager.find(Passenger.class, passengerID);

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
    @Transactional
    public void createPassenger(String name) {
        Passenger passenger = new Passenger();
        passenger.setName(name);
        entityManager.persist(passenger);
    }

    @Override
    @Transactional
    public String deletePassenger(int id) {
        Passenger passenger = entityManager.find(Passenger.class, id);
        String passengerName = passenger.getName();
        entityManager.remove(passenger);
        return passengerName;
    }

    @Override
    @Transactional
    public void updatePassenger(int id, String newName) {
        Passenger passenger = findPassenger(id);
        entityManager.detach(passenger);
        passenger.setName(newName);
        entityManager.merge(passenger);
    }
}
