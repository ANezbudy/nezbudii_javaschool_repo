package com.project.dto;

import com.project.entity.Tickets;
import java.util.Date;

public class PassengerDTO {
    private int id;
    private String passengerName;
    private String passengerLastName;
    private String passengerBirthDate;
    private Tickets ticket;

    public PassengerDTO() {
    }

    public PassengerDTO(String passengerName, String passengerLastName, String passengerBirthDate) {
        this.passengerName = passengerName;
        this.passengerLastName = passengerLastName;
        this.passengerBirthDate = passengerBirthDate;
    }

    public PassengerDTO(int id, String passengerName, String passengerLastName, String passengerBirthDate) {
        this.id = id;
        this.passengerName = passengerName;
        this.passengerLastName = passengerLastName;
        this.passengerBirthDate = passengerBirthDate;
    }

    public PassengerDTO(int id, String passengerName, String passengerLastName, String passengerBirthDate, Tickets ticket) {
        this.id = id;
        this.passengerName = passengerName;
        this.passengerLastName = passengerLastName;
        this.passengerBirthDate = passengerBirthDate;
        this.ticket = ticket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPassengerBirthDate() {
        return passengerBirthDate;
    }

    public void setPassengerBirthDate(String passengerBirthDate) {
        this.passengerBirthDate = passengerBirthDate;
    }

    public Tickets getTicket() {
        return ticket;
    }

    public void setTicket(Tickets ticket) {
        this.ticket = ticket;
    }
}
