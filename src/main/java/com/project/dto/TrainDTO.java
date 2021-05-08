package com.project.dto;

import java.util.Set;

public class TrainDTO {
    private int trainNumber;
    private int numPlaces;
    private Set<TicketsDTO> ticketsDTOs;
    private Set<StationDTO> stationDTOS;

//    public TrainDTO() {
//
//    }
//
//    public TrainDTO(int trainNumber, int numPlaces) {
//        this.trainNumber = trainNumber;
//        this.numPlaces = numPlaces;
//    }
//
//    public TrainDTO(int trainNumber, int numPlaces, Set<TicketsDTO> ticketsDTOs, Set<StationDTO> stationDTOS) {
//        this.trainNumber = trainNumber;
//        this.numPlaces = numPlaces;
//        this.ticketsDTOs = ticketsDTOs;
//        this.stationDTOS = stationDTOS;
//    }

    public int getTrainNumber() {
        return trainNumber;
    }

    //TODO: add exception handling?
    public void setTrainNumber(String trainNumber) {
        this.trainNumber = Integer.parseInt(trainNumber);
    }

    public int getNumPlaces() {
        return numPlaces;
    }

    //TODO: add exception handling?
    public void setNumPlaces(String numPlaces) {
        this.numPlaces = Integer.parseInt(numPlaces);
    }

    public Set<TicketsDTO> getTicketsDTOs() {
        return ticketsDTOs;
    }

    public void setTicketsDTOs(Set<TicketsDTO> ticketsDTOs) {
        this.ticketsDTOs = ticketsDTOs;
    }

    public Set<StationDTO> getStationsDTOS() {
        return stationDTOS;
    }

    public void setStationsDTOS(Set<StationDTO> stationDTOS) {
        this.stationDTOS = stationDTOS;
    }
}
