package com.project.dao.impl;

import com.project.dao.api.TicketDAO;
import com.project.entity.Passenger;
import com.project.entity.Ticket;
import com.project.entity.Train;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TicketDAOImpl implements TicketDAO {
    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public List<Ticket> findTrainTickets(int trainNumber) {
        Query query = entityManager.createQuery("FROM Ticket WHERE trainNumber = :trainNumber");
        query.setParameter("trainNumber", trainNumber);
        return query.getResultList();
    }

    @Override
    public int createTicket(Passenger passenger, int trainNumber) {
        Ticket ticket = new Ticket();
//        ticket.setPassenger(passenger);
        ticket.setTranNumber(trainNumber);
        entityManager.persist(ticket);
        return ticket.getId();
    }
}
