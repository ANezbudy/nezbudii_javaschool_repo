package com.project.dao.impl;

import com.project.dao.api.TicketDAO;
import com.project.entity.Ticket;
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
    public List<Ticket> findTrainAndPassengerTickets(int trainNumber, int passengerId) {
        Query query = entityManager.createQuery("FROM Ticket WHERE trainNumber = :trainNumber AND passengerId = :passengerId");
        query.setParameter("trainNumber", trainNumber);
        query.setParameter("passengerId", passengerId);
        return query.getResultList();
    }

    @Override
    public void createTicket(int passengerId, int trainNumber) {
        Ticket ticket = new Ticket();
        ticket.setPassengerId(passengerId);
        ticket.setTrainNumber(trainNumber);
        entityManager.persist(ticket);
    }
}
