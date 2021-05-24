package com.project.controller;

import com.project.dto.StationDTO;
import com.project.service.api.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StationRestController {

    @Autowired
    StationService stationService;

    @GetMapping("/api/stations")
    public List<StationDTO> allStations() {
        List<StationDTO> stationDTOList = stationService.findAllStations();
        return stationDTOList;
    }
}
