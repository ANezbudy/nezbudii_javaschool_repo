package com.project.dao.api;

import com.project.entity.Ticket;

import java.util.List;

public interface TicketDAO {
    List<Ticket> findTrainTickets(int trainNumber);
}
