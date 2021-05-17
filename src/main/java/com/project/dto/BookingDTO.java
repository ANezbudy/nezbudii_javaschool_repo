package com.project.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class BookingDTO {
    int trainNumber;

    String stationName;

    int scheduleId;

    String passengerName;

    String passengerLastName;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm")
    Date passengerBirthDate;

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = Integer.parseInt(trainNumber);
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = Integer.parseInt(scheduleId);
    }
}
