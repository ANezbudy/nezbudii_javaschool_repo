package com.project.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BookingDTO {
    int trainNumber;

    String stationName;

    int scheduleId;

    String passengerName;

    String passengerLastName;

    Date passengerBirthDate;

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    Date departureTime;

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

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerLastName() {
        return passengerLastName;
    }

    public void setPassengerLastName(String passengerLastName) {
        this.passengerLastName = passengerLastName;
    }

    public Date getPassengerBirthDate() {
        return passengerBirthDate;
    }

    public void setPassengerBirthDate(String passengerBirthDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.passengerBirthDate = format.parse(passengerBirthDate);
        } catch (ParseException exception) {
            //TODO add logging
            exception.printStackTrace();
        }
    }
}
