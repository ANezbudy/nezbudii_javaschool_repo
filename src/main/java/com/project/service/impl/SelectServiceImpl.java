package com.project.service.impl;

import com.project.dao.api.StationDAO;
import com.project.entity.Schedule;
import com.project.entity.Station;
import com.project.service.api.SelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SelectServiceImpl implements SelectService {
    @Autowired
    StationDAO stationDAO;

    @Override
    public List<Integer> findCommonTrains(int stationAiD, int stationBiD) {
        List<Schedule> schedulesA = stationDAO.findStation(stationAiD).getSchedules();
        List<Schedule> schedulesB = stationDAO.findStation(stationBiD).getSchedules();

        List<Integer> trainsA = schedulesA.stream().map(schedule -> {return schedule.getTrain().getTrainNumber();})
                .collect(Collectors.toList());

        List<Integer> trainsB = schedulesB.stream().map(schedule -> {return schedule.getTrain().getTrainNumber();})
                .collect(Collectors.toList());

        trainsA.retainAll(trainsB);
        return trainsA;
    }

    @Override
    public List<Schedule> findDepartureTrainsForTrip(List<Integer> commonTrains, String departureTimeA) throws ParseException {
        List<Schedule> resultSchedulesA = new ArrayList<Schedule>();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        Date departureTimeFormatedA = format.parse(departureTimeA);

        for (int train:commonTrains) {
            for (Schedule schedule:schedulesA) {
                if(schedule.getTrain().getTrainNumber() == train && schedule.getDepartureTime().before(departureTimeFormatedA)) {
                    resultSchedulesA.add(schedule);
                }
            }
        }
        return resultSchedulesA;
    }

    @Override
    public List<Schedule> findArrivalTrainsForTrip(List<Integer> commonTrains, String arrivalTimeB) throws ParseException {
        List<Schedule> resultSchedulesB = new ArrayList<Schedule>();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        Date arrivalTimeFormatedB = format.parse(arrivalTimeB);

        for (int train:commonTrains) {
            for (Schedule schedule:schedulesB) {
                if(schedule.getTrain().getTrainNumber() == train && arrivalTimeFormatedB.before(schedule.getArrivalTime())) {
                    resultSchedulesB.add(schedule);
                }
            }
        }
        return resultSchedulesB;
    }


}
