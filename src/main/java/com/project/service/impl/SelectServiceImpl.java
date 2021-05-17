package com.project.service.impl;

import com.project.dao.api.StationDAO;
import com.project.dto.TripDTO;
import com.project.entity.Schedule;
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
    public List<TripDTO> findDepartureTrainsForTrip(int stationAiD, int stationBiD, String timeOne, String  timeTwo) throws ParseException {
        List<Integer> commonTrains = findCommonTrains(stationAiD, stationBiD);
        List<Schedule> resultSchedulesA = new ArrayList<Schedule>();
        List<Schedule> resultSchedulesB = new ArrayList<Schedule>();
        List<Schedule> schedulesA = stationDAO.findStation(stationAiD).getSchedules();
        List<Schedule> schedulesB = stationDAO.findStation(stationBiD).getSchedules();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        Date timeOneFormated = format.parse(timeOne);
        Date timeTwoFormated = format.parse(timeTwo);

        for (int train:commonTrains) {
            for (Schedule schedule:schedulesB) {
                if(schedule.getTrain().getTrainNumber() == train) {
                    resultSchedulesB.add(schedule);
                }
            }

            for (Schedule schedule:schedulesA) {
                if(schedule.getTrain().getTrainNumber() == train && schedule.getDepartureTime().after(timeOneFormated)
                        && schedule.getDepartureTime().before(timeTwoFormated)) {
                    resultSchedulesA.add(schedule);
                }
            }
        }

        return resultSchedulesA.stream().map(schedule -> {
            TripDTO tripDTO = new TripDTO();
            tripDTO.setDepartureStationName(schedule.getStation().getStationName());
            tripDTO.setDepartureTime(schedule.getDepartureTime());
            tripDTO.setTrainNumber(schedule.getTrain().getTrainNumber());
            tripDTO.setScheduleId(schedule.getId());

            for(Schedule schedule1 : resultSchedulesB) {
                if(schedule.getTrain().getTrainNumber() == schedule.getTrain().getTrainNumber()
                    && schedule1.getArrivalTime().after(schedule.getDepartureTime())) {
                    tripDTO.setArrivalTime(schedule1.getArrivalTime());
                    tripDTO.setArrivalStationName(schedule1.getStation().getStationName());
                }
            }
            return tripDTO;
        }).collect(Collectors.toList());
    }

}
