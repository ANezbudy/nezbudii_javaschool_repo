package com.project.sbb_nau.service;

import com.project.sbb_nau.entity.Station;

import java.util.List;

public interface StationService {
    List<Station> listAllStations();

    void saveStation(Station station);

    Station getStation(Integer id);

    void deleteStation(Integer id);
}
