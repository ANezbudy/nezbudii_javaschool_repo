package com.project.dto;

public class PassengerDTO {
    private int id;
    private String passengerName;
    private String passengerLastName;
    private String passengerBirthDate;
    private TicketsDTO ticketsDTO;

//    public PassengerDTO() {
//    }
//
//    public PassengerDTO(String passengerName, String passengerLastName, String passengerBirthDate) {
//        this.passengerName = passengerName;
//        this.passengerLastName = passengerLastName;
//        this.passengerBirthDate = passengerBirthDate;
//    }
//
//    public PassengerDTO(int id, String passengerName, String passengerLastName, String passengerBirthDate) {
//        this.id = id;
//        this.passengerName = passengerName;
//        this.passengerLastName = passengerLastName;
//        this.passengerBirthDate = passengerBirthDate;
//    }
//
//    public PassengerDTO(int id, String passengerName, String passengerLastName, String passengerBirthDate, TicketsDTO ticketsDTO) {
//        this.id = id;
//        this.passengerName = passengerName;
//        this.passengerLastName = passengerLastName;
//        this.passengerBirthDate = passengerBirthDate;
//        this.ticketsDTO = ticketsDTO;
//    }

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
