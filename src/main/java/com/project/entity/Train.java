package com.project.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "trains")
public class Train {
    @Id
    @Column(name = "trainNumber")
    private int trainNumber;

    @Column(name = "num_places")
    private int numPlaces;

    @Column(name = "emptyPlaces")
    private int emptyPlaces;

//    @OneToMany(mappedBy = "train", fetch = FetchType.LAZY)
//    private List<Ticket> tickets;

    @OneToMany(mappedBy = "train", fetch = FetchType.EAGER)
    private List<Schedule> schedules;

    public int getEmptyPlaces() {
        return emptyPlaces;
    }

    public void setEmptyPlaces(int emptyPlaces) {
        this.emptyPlaces = emptyPlaces;
    }

//    public void setTickets(List<Ticket> tickets) {
//        this.tickets = tickets;
//    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }



    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int train_number) {
        this.trainNumber = train_number;
    }

    public int getNumPlaces() {
        return numPlaces;
    }

    public void setNumPlaces(int num_places) {
        this.numPlaces = num_places;
    }

//    public List<Ticket> getTickets() {
//        return tickets;
//    }

}
