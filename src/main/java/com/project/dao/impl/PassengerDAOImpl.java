package com.project.dao.impl;

import com.project.dao.api.PassengerDAO;
import com.project.entity.Passenger;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@ComponentScan(basePackages = "com/project/config")
public class PassengerDAOImpl implements PassengerDAO {
    //the example of the logging
    private static final Logger LOG = LogManager.getLogger(PassengerDAOImpl.class);

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public Passenger findPassengerByID(int passengerId) {
        Passenger passenger = entityManager.find(Passenger.class, passengerId);

        if (passenger != null) {
            entityManager.detach(passenger);
//            if (passenger.getTicket() != null) {
//                entityManager.detach(passenger.getTicket());
//            }
        }
        return passenger;
    }

    @Override
    public List<Passenger> findAllPassengers() {
        //TODO create pagination
        return entityManager.createQuery("FROM Passenger").getResultList();
    }

    @Override
    public void createPassenger(Passenger passenger) {
        entityManager.persist(passenger);
    }

    @Override
    public Passenger createPassenger(String passengerName, String passengerLastName, Date passengerBirthDate) {
        Passenger passenger = new Passenger();
        passenger.setPassengerName(passengerName);
        passenger.setPassengerLastName(passengerLastName);
        passenger.setPassengerBirthDate(passengerBirthDate);
        entityManager.persist(passenger);
        return passenger;
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
        Passenger passenger = entityManager.find(Passenger.class, id);
        passenger.setPassengerName(passengerName);
        passenger.setPassengerLastName(passengerLastName);
        passenger.setPassengerBirthDate(passengerBirthDate);
        entityManager.merge(passenger);
    }

    @Override
    public Passenger findPassenger(String fistName, String lastName, Date birthDate) {
//        Query query = entityManager.createQuery("FROM (FROM (FROM Passenger WHERE passengerName = :fistName) as pName WHERE passengerLastName = :lastName) as pLastName WHERE passengerBirthDate = :birthDate");
        Query query = entityManager.createQuery("FROM Passenger WHERE passengerName = :fistName AND passengerLastName = :lastName AND passengerBirthDate = :birthDate");

        query.setParameter("fistName", fistName);
        query.setParameter("lastName", lastName);
        query.setParameter("birthDate", birthDate);
        if (query.getResultList().size() > 0) {
            return (Passenger)query.getResultList().get(0);
        } else return null;
    }
}
