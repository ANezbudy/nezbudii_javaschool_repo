package com.project.service.impl;

import com.project.dao.api.PassengerDAO;
import com.project.dao.api.TicketDAO;
import com.project.dao.api.TrainDAO;
import com.project.dto.TrainPassengerDTO;
import com.project.entity.Passenger;
import com.project.entity.Ticket;
import com.project.service.api.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    TrainDAO trainDAO;

    @Autowired
    PassengerDAO passengerDAO;

    @Autowired
    TicketDAO ticketDAO;

    @Override
    public List<TrainPassengerDTO> findTrainPassengers(int trainNumber) {
//        List<Ticket> tickets = trainDAO.findTrain(trainNumber).getTickets();
        List<Ticket> tickets = ticketDAO.findTrainTickets(trainNumber);


        return tickets.stream().map(ticket -> {
            Passenger passenger = passengerDAO.findPassengerByID(ticket.getPassengerId());
            TrainPassengerDTO trainPassengerDTO = new TrainPassengerDTO();
            trainPassengerDTO.setPassengerName(passenger.getPassengerName());
            trainPassengerDTO.setPassengerLastName(passenger.getPassengerLastName());
            trainPassengerDTO.setPassengerBirthDate(passenger.getPassengerBirthDate());
            return trainPassengerDTO;
        }).collect(Collectors.toList());
    }
}
