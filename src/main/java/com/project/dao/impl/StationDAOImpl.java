package com.project.dao.impl;

import com.project.dao.api.StationDAO;
import com.project.entity.Station;
import com.project.utils.StationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@ComponentScan(basePackages = "com/project/config")
public class StationDAOImpl implements StationDAO {
    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public Station findStation(int stationId) {
        Station station = entityManager.find(Station.class, stationId);
        if(station != null) {
            entityManager.detach(station);
        }
        return station;
    }

    @Override
    public List<Station> findAllStations() {
        //TODO make pagination
        return entityManager.createQuery("FROM Station").getResultList();
    }

    @Override
    public void createStation(Station station) {
        entityManager.persist(station);
    }

    @Override
    public int deleteStation(int stationId) {
        Station station = entityManager.find(Station.class, stationId);
        if(station != null) {
            entityManager.remove(station);
            return 1;
        }
        return 0;
    }

    @Override
    public void updateStation(int stationId, String stationName) {
        Station station = entityManager.find(Station.class, stationId);
        entityManager.detach(station);
        station.setStationName(stationName);
        entityManager.merge(station);
    }
}
