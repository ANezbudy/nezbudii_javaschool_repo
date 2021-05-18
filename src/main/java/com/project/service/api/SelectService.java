package com.project.service.api;

import com.project.dto.TripDTO;

import java.text.ParseException;
import java.util.List;

public interface SelectService {
    List<Integer> findCommonTrains(int stationAiD, int stationBiD);

    List<TripDTO> findDepartureTrainsForTrip(int stationAiD, int stationBiD, String timeOne, String  timeTwo) throws ParseException;
}
