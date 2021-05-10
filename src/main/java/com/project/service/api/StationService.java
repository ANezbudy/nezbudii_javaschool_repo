package com.project.service.api;


import com.project.dto.StationDTO;

import java.util.List;

public interface StationService {
    StationDTO findStation(StationDTO stationDTO);

    List<StationDTO> findAllStations();

    void createStation(StationDTO stationDTO);

    int deleteStation(StationDTO stationDTO);

    void updateStation(StationDTO stationDTO);
}
