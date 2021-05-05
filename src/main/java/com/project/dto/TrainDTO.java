package com.project.dto;

import com.project.entity.Stations;
import com.project.entity.Tickets;

import java.util.Set;

public class TrainDTO {
    private int trainNumber;
    private int numPlaces;
    private Set<Tickets> tickets;
    private Set<Stations> stations;

    public TrainDTO() {

    }

    public TrainDTO(int trainNumber, int numPlaces) {
        this.trainNumber = trainNumber;
        this.numPlaces = numPlaces;
    }

    public TrainDTO(int trainNumber, int numPlaces, Set<Tickets> tickets, Set<Stations> stations) {
        this.trainNumber = trainNumber;
        this.numPlaces = numPlaces;
        this.tickets = tickets;
        this.stations = stations;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public int getNumPlaces() {
        return numPlaces;
    }

    public void setNumPlaces(int numPlaces) {
        this.numPlaces = numPlaces;
    }

    public Set<Tickets> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Tickets> tickets) {
        this.tickets = tickets;
    }

    public Set<Stations> getStations() {
        return stations;
    }

    public void setStations(Set<Stations> stations) {
        this.stations = stations;
    }
}
