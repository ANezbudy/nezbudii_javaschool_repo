package com.project.service.api;

import com.project.entity.Schedule;

import java.text.ParseException;
import java.util.List;

public interface SelectService {
    List<Integer> findCommonTrains(int stationAiD, int stationBiD);

    List<Schedule> findDepartureTrainsForTrip(List<Integer> commonTrains, String departureTimeA) throws ParseException;

    List<Schedule> findArrivalTrainsForTrip(List<Integer> commonTrains, String arrivalTimeB) throws ParseException;
}
