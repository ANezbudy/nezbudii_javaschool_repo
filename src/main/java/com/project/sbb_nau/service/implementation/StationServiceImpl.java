package com.project.sbb_nau.service.implementation;

import com.project.sbb_nau.entity.Station;
import com.project.sbb_nau.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StationServiceImpl implements com.project.sbb_nau.service.StationService {
    @Autowired
    private StationRepository stationRepository;

    @Override
    public List<Station> listAllStations() {
        return stationRepository.findAll();
    }

    @Override
    public void saveStation(Station station) {
        stationRepository.save(station);
    }

    @Override
    public Station getStation(Integer id) {
        return stationRepository.findById(id).get();
    }

    @Override
    public void deleteStation(Integer id) {
        stationRepository.deleteById(id);
    }

//    public List<Schedule> getStationSchedules(int id) {
//        return stationRepository.findSchedulesById(id);
//    }
}
