package com.project.dto;

public class TicketsDTO {
    private int id;
    private TrainDTO trainDTO;
    private PassengerDTO passengerDTO;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TrainDTO getTrainDTO() {
        return trainDTO;
    }

    public void setTrainDTO(TrainDTO trainDTO) {
        this.trainDTO = trainDTO;
    }

    public PassengerDTO getPassengerDTO() {
        return passengerDTO;
    }

    public void setPassengerDTO(PassengerDTO passengerDTO) {
        this.passengerDTO = passengerDTO;
    }
}
