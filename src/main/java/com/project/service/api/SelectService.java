package com.project.service.api;

import com.project.entity.Schedule;

import java.text.ParseException;
import java.util.List;

public interface SelectService {
    List<Integer> findCommonTrains(String stationNameA, String stationNameB);

    List<Schedule> findDepartureTrainsForTrip(String stationNameA, String stationNameB, String departureTimeA) throws ParseException;

    List<Schedule> findArrivalTrainsForTrip(String stationNameA, String stationNameB, String arrivalTimeB) throws ParseException;
}
