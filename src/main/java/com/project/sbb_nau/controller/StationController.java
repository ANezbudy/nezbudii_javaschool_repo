package com.project.sbb_nau.controller;

import com.project.sbb_nau.config.dto.StationDto;
import com.project.sbb_nau.entity.Schedule;
import com.project.sbb_nau.entity.Station;
import com.project.sbb_nau.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:8081")
public class StationController {
    @Autowired
    StationService stationService;

    @GetMapping("/stations")
    public List<Station> listAllStations() {
        return stationService.listAllStations();
    }

    @PostMapping("/stations/create")
    public String createStation(@RequestBody StationDto stationDto) {
        Station station = new Station();
        station.setStationName(stationDto.getStationName());
        stationService.saveStation(station);
        return "Station created";
    }

    @PutMapping("/station/update")
    public String updateStation(@RequestBody StationDto stationDto) {
        Station station = stationService.getStation(stationDto.getId());
        station.setStationName(stationDto.getStationName());
        stationService.saveStation(station);
        return "Station updated";
    }

    @DeleteMapping("/station/delete")
    public String deleteStation(@RequestBody StationDto stationDto) {
        stationService.deleteStation(stationDto.getId());
        return "Station deleted";
    }

    @GetMapping("/station/schedules")
    public List<Schedule> getStationSchedule(@RequestBody StationDto stationDto) {
        return stationService.getStationSchedules(stationDto.getId());
    }

}
