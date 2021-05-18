package com.project.dto;

import com.project.entity.Train;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScheduleDTO {
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");

    private int id;
    private Train train;
//    private Station station;
    private int stationId;

    private int trainNumber;

//    @DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm")
    private Date arrivalTime;

//    @DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm")
    private Date departureTime;

    public int getId() {
        return id;
    }

    public void setId(String id) {
        this.id = Integer.parseInt(id);
    }

    public void setId(int id) {
        this.id = id;
    }

    //    public Train getTrain() {
//        return train;
//    }

//    public void setTrain(Train train) {
//        this.train = train;
//    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        int id = Integer.parseInt(stationId);
        this.stationId = id;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        try {
            this.arrivalTime = format.parse(arrivalTime);
        } catch (ParseException exception) {
            exception.printStackTrace();
        }
    }

    public void setArrivalTime(Date arrivalTime) {
            this.arrivalTime = arrivalTime;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        try {
            this.departureTime = format.parse(departureTime);
        } catch (ParseException exception) {
            exception.printStackTrace();
        }
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = Integer.parseInt(trainNumber);
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

//    public Station getStation() {
//        return station;
//    }
//
//    public void setStation(Station station) {
//        this.station = station;
//    }
}
