package com.project.dto;

public class PassengerDTO {
    private int id;
    private String passengerName;
    private String passengerLastName;
    private String passengerBirthDate;
    private TicketsDTO ticketsDTO;

    public int getId() {
        return id;
    }

    public void setId(String id) {
        this.id = Integer.parseInt(id);
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

    public TicketsDTO getTicketsDTO() {
        return ticketsDTO;
    }

    public void setTicketsDTO(TicketsDTO ticketsDTO) {
        this.ticketsDTO = ticketsDTO;
    }
}
