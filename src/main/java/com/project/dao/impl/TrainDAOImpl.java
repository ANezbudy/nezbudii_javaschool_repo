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

    @Autowired
    private TrainMapper trainMapper;

    @Override
    public TrainDTO findTrain(int trainNumber) {
        Train train = entityManager.find(Train.class, trainNumber);

        if(train != null) {
            entityManager.detach(train);
        }

        return trainMapper.toDto(train);
    }

    @Override
    public List<TrainDTO> findAllTrains() {
        List<Train> trains = entityManager.createQuery("FROM Train").getResultList();
        return trains.stream().map(trainMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void createTrain(TrainDTO trainDTO) {
        Train train = trainMapper.toEntity(trainDTO);
        entityManager.persist(train);
    }

    @Override
    public int deleteTrain(TrainDTO trainDTO) {
        Train train = trainMapper.toEntity(trainDTO);
        if (train != null) {
            entityManager.remove(train);
            return 1;
        }
        return 0;
    }

    @Override
    public void updateTrain(TrainDTO trainDTO) {
        Train train = entityManager.find(Train.class, trainDTO.getTrainNumber());
        entityManager.detach(train);
        train = trainMapper.toEntity(trainDTO);
        entityManager.merge(train);
    }
}
