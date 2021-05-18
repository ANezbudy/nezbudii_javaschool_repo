package com.project.dao.api;

import com.project.entity.Station;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface StationDAO {
    Station findStation(int id);

    List<Station> findStationsByName(String stationName);

    List<Station> findAllStations();

    void createStation(Station station);

    int deleteStation(int stationId);

    void updateStation(int stationId, String stationName);
}
