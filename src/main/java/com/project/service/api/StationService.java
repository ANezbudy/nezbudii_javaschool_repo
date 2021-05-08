package com.project.service.api;


import com.project.dto.StationDTO;

import java.util.List;

public interface StationService {
    StationDTO findStation(int id);

    List<StationDTO> findAllStations();

    void createStation(String stationName);

    int deleteStation(int stationId);

    void updateStation(int stationId, String statioinName);
}
