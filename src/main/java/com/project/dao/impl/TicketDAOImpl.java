package com.project.dao.impl;

import com.project.dao.api.TicketDAO;
import com.project.entity.Ticket;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class TicketDAOImpl implements TicketDAO {
    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public List<Ticket> findTrainTickets(int trainNumber) {
        Query query = entityManager.createQuery("FROM Ticket WHERE trainNumber = :trainNumber");
        query.setParameter("trainNumber", trainNumber);
        return query.getResultList();
    }
}
