package com.project.dto;

import com.project.entity.Train;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ScheduleDTO {
    private int id;
    private Train train;
    private int stationId;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm")
    private Date arrivalTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm")
    private Date departureTime;

    public int getId() {
        return id;
    }

    public void setId(String id) {
        this.id = Integer.parseInt(id);
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        int id = Integer.parseInt(stationId);
        this.stationId = id;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }
}
