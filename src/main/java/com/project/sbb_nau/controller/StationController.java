package com.project.sbb_nau.controller;

import com.project.sbb_nau.entity.Station;
import com.project.sbb_nau.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/stations")
public class StationController {
    @Autowired
    StationService stationService;

    @GetMapping("")
    public List<Station> listAllStations() {
        return stationService.listAllStations();
    }
}
