package com.project.dao.impl;

import com.project.dao.api.PassengerDAO;
import com.project.dto.PassengerDTO;
import com.project.entity.Passenger;
import com.project.utils.PassengerMapper;
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

    @PersistenceContext
    protected EntityManager entityManager;

    @Autowired
    private PassengerMapper passengerMapper;

    @Override
    public PassengerDTO findPassengerByID(int passengerId) {
        Passenger passenger = entityManager.find(Passenger.class, passengerId);

        if (passenger != null) {
            entityManager.detach(passenger);
            if (passenger.getTicket() != null) {
                entityManager.detach(passenger.getTicket());
            }
        }

        return passengerMapper.toDto(passenger);
    }

    @Override
    public List<PassengerDTO> findAllPassengers() {
        List<Passenger> passengers = entityManager.createQuery("FROM Passenger").getResultList();
        return passengers.stream().map(passengerMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void createPassenger(String passengerName, String passengerLastName, String passengerBirthDate) {
        PassengerDTO passengerDTO = new PassengerDTO(passengerName, passengerLastName, passengerBirthDate);
        Passenger passenger = passengerMapper.toEntity(passengerDTO);
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
    public void updatePassenger(int id, String passengerName, String passengerLastName, String passengerBirthDate) {
        PassengerDTO passengerDTO = new PassengerDTO(id, passengerName, passengerLastName, passengerBirthDate);
        Passenger passenger = passengerMapper.toEntity(passengerDTO);
        entityManager.merge(passenger);
    }
}
