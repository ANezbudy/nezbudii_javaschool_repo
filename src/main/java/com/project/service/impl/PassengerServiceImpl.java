package com.project.service.impl;

import com.project.dao.api.PassengerDAO;
import com.project.dto.PassengerDTO;
import com.project.entity.Passenger;
import com.project.service.api.PassengerService;
import com.project.utils.PassengerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerDAO passengerDAO;

    @Autowired
    private PassengerMapper passengerMapper;

    @Override
    public PassengerDTO findPassenger(PassengerDTO passengerDTO) {
        return passengerMapper.toDto(passengerDAO.findPassengerByID(passengerDTO.getId()));
    }

    @Override
    public List<PassengerDTO> findAllPassengers() {
        return passengerDAO.findAllPassengers().stream().map(s -> passengerMapper.toDto(s)).collect(Collectors.toList());
    }

    @Override
    public void createPassenger(PassengerDTO passengerDTO) {
        Passenger passenger = passengerMapper.toEntity(passengerDTO);
        passengerDAO.createPassenger(passenger);
    }

    @Override
    public int deletePassengerById(PassengerDTO passengerDTO) {
        return passengerDAO.deletePassengerById(passengerDTO.getId());
    }

    @Override
    public void updatePassenger(PassengerDTO passengerDTO) {
        Passenger passenger = passengerMapper.toEntity(passengerDTO);
        passengerDAO.updatePassenger(
                passenger.getId(),
                passenger.getPassengerName(),
                passenger.getPassengerLastName(),
                passenger.getPassengerBirthDate());
    }
}
