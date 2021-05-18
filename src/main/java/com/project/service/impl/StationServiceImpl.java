package com.project.service.impl;

import com.project.dao.api.StationDAO;
import com.project.dto.StationDTO;
import com.project.service.api.StationService;
import com.project.utils.StationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StationServiceImpl implements StationService {
    @Autowired
    private StationDAO stationDAO;

    @Autowired
    StationMapper stationMapper;

    @Override
    public StationDTO findStation(StationDTO stationDTO) {
        return stationMapper.toDto(stationDAO.findStation(stationDTO.getId()));
    }

    @Override
    public List<StationDTO> findAllStations() {
        return stationDAO.findAllStations().stream().map(s -> stationMapper.toDto(s)).collect(Collectors.toList());
    }

    @Override
    public void createStation(StationDTO stationDTO) {
        stationDAO.createStation(stationMapper.toEntity(stationDTO));
    }

    @Override
    public int deleteStation(StationDTO stationDTO) {
        return stationDAO.deleteStation(stationDTO.getId()) == 1 ? stationDTO.getId() : 0;
    }

    @Override
    public void updateStation(StationDTO stationDTO) {
        stationDAO.updateStation(stationDTO.getId(), stationDTO.getStationName());
    }
}
