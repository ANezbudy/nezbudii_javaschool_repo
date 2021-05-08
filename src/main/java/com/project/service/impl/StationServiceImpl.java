package com.project.service.impl;

import com.project.dao.api.StationDAO;
import com.project.dto.StationDTO;
import com.project.service.api.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationServiceImpl implements StationService {
    @Autowired
    private StationDAO stationDAO;

    @Override
    public StationDTO findStation(int id) {
        return stationDAO.findStation(id);
    }

    @Override
    public List<StationDTO> findAllStations() {
        return stationDAO.findAllStations();
    }

    @Override
    public void createStation(String stationName) {
        StationDTO stationDTO = new StationDTO(stationName);
        stationDAO.createStation(stationDTO);
    }

    @Override
    public int deleteStation(int stationId) {
        StationDTO stationDTO = new StationDTO();
        stationDTO.setId(stationId);
        return stationDAO.deleteStation(stationDTO) == 1 ? stationId : 0;
    }

    @Override
    public void updateStation(int stationId, String stationName) {
        StationDTO stationDTO = new StationDTO();
        stationDTO.setId(stationId);
        stationDTO.setStationName(stationName);
        stationDAO.updateStation(stationDTO);
    }
}
