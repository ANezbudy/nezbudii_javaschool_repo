package com.project.dao.impl;

import com.project.dao.api.TrainDAO;
import com.project.entity.Train;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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
        List<Train> trains = entityManager.createQuery("FROM Train").getResultList();
        return trains;
    }

    @Override
    public void createTrain(int trainNumber, int numPlaces) {
        Train train = new Train();
        train.setTrainNumber(trainNumber);
        train.setNumPlaces(numPlaces);
        entityManager.persist(train);
    }

    @Override
    public int deleteTrain(int trainNumber) {
        Train train = entityManager.find(Train.class, trainNumber);
        if (train != null) {
            entityManager.remove(train);
            return trainNumber;
        }
        return 0;
    }

    @Override
    public void updateTrain(int trainNumber, int numPlaces) {
        Train train = findTrain(trainNumber);
        entityManager.detach(train);
        train.setTrainNumber(trainNumber);
        train.setNumPlaces(numPlaces);
        entityManager.merge(train);
    }
}
