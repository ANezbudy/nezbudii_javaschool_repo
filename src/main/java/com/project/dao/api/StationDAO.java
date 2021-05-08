package com.project.dao.api;

import com.project.dto.StationDTO;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface StationDAO {
    StationDTO findStation(int id);

    List<StationDTO> findAllStations();

    void createStation(StationDTO stationDTO);

    int deleteStation(StationDTO stationDTO);

    void updateStation(StationDTO stationDTO);
}
