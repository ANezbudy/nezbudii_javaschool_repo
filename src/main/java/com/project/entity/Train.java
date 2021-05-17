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

    @OneToMany(mappedBy = "train", fetch = FetchType.EAGER)
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "train", fetch = FetchType.LAZY)
    private List<Schedule> schedules;

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

    public List<Ticket> getTickets() {
        return tickets;
    }

}
