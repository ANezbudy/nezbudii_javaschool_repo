package com.project.dao.impl;

import com.project.dao.api.PassengerDAO;
import com.project.dto.PassengerDTO;
import com.project.entity.Passenger;
import com.project.utils.PassengerMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
            if (passenger.getTicket() != null) {
                entityManager.detach(passenger.getTicket());
            }
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
}
