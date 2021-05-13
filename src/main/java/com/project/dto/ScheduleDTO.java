package com.project.dto;

public class ScheduleDTO {
    private int id;
    private int trainNumber;
    private int stationId;
    private String arrivalTime;
    private String departureTime;

    public int getId() {
        return id;
    }

    public void setId(String id) {
        this.id = Integer.parseInt(id);
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        int number = Integer.parseInt(trainNumber);
        this.trainNumber = number;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        int id = Integer.parseInt(stationId);
        this.stationId = id;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
}
