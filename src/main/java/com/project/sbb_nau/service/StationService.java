package com.project.sbb_nau.service;

import com.project.sbb_nau.entity.Station;
import com.project.sbb_nau.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StationService {
    @Autowired
    private StationRepository stationRepository;

    public List<Station> listAllStations() {
        return stationRepository.findAll();
    }

    public void saveStation(Station station) {
        stationRepository.save(station);
    }

    public Station getStation(Integer id) {
        return stationRepository.findById(id).get();
    }

    public void deleteStation(Integer id) {
        stationRepository.deleteById(id);
    }
}
