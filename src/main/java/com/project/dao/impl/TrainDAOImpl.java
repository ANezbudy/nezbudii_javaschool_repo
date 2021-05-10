package com.project.dao.impl;

import com.project.dao.api.TrainDAO;
import com.project.dto.TrainDTO;
import com.project.entity.Train;
import com.project.utils.TrainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@ComponentScan(basePackages = "com/project/config")
public class TrainDAOImpl implements TrainDAO {
    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public Train findTrain(int trainNumber) {
        Train train = entityManager.find(Train.class, trainNumber);

        if(train != null) {
            entityManager.detach(train);
        }

        return train;
    }

    @Override
    public List<Train> findAllTrains() {
        return entityManager.createQuery("FROM Train").getResultList();
    }

    @Override
    public void createTrain(Train train) {
        entityManager.persist(train);
    }

    @Override
    public int deleteTrain(int trainNumber) {
        Train train = entityManager.find(Train.class, trainNumber);
        if (train != null) {
            entityManager.remove(train);
            return 1;
        }
        return 0;
    }

    @Override
    public void updateTrain(int trainNumber, int numPlaces) {
        Train train = entityManager.find(Train.class, trainNumber);
        entityManager.detach(train);
        train.setNumPlaces(numPlaces);
        entityManager.merge(train);
    }
}
