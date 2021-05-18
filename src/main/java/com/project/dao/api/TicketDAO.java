package com.project.dao.api;

import com.project.entity.Ticket;

import java.util.List;

public interface TicketDAO {
    List<Ticket> findTrainTickets(int trainNumber);

    void createTicket(int passengerId, int trainNumber);

    public List<Ticket> findTrainAndPassengerTickets(int trainNumber, int passengerId);
}
