package com.project.dao.api;

import com.project.entity.Passenger;
import com.project.entity.Ticket;

import java.util.List;

public interface TicketDAO {
    List<Ticket> findTrainTickets(int trainNumber);

    int createTicket(Passenger passenger, int trainNumber);
}
