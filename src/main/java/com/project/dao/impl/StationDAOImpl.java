package com.project.dao.impl;

import com.project.dao.api.StationDAO;
import com.project.dto.StationDTO;
import com.project.entity.Station;
import com.project.utils.StationMapper;
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
public class StationDAOImpl implements StationDAO {
    @PersistenceContext
    protected EntityManager entityManager;

    @Autowired
    protected StationMapper stationMapper;

    @Override
    public StationDTO findStation(int id) {
        Station station = entityManager.find(Station.class, id);
        if(station != null) {
            entityManager.detach(station);
        }
        return stationMapper.toDto(station);
    }

    @Override
    public List<StationDTO> findAllStations() {
        List<Station> stations = entityManager.createQuery("FROM Station").getResultList();
        return stations.stream().map(stationMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void createStation(StationDTO stationDTO) {
        Station station = stationMapper.toEntity(stationDTO);
        entityManager.persist(station);
    }

    @Override
    public int deleteStation(StationDTO stationDTO) {
        Station station = entityManager.find(Station.class, stationDTO.getId());
        if(station != null) {
            entityManager.remove(station);
            return 1;
        }
        return 0;
    }

    @Override
    public void updateStation(StationDTO stationDTO) {
        Station station = entityManager.find(Station.class, stationDTO.getId());
        entityManager.detach(station);
        station = stationMapper.toEntity(stationDTO);
        entityManager.merge(station);
    }
}
