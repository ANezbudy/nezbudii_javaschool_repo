package com.project.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "trains")
public class Train {
    @Id
    @Column(name = "train_number")
    private int trainNumber;

    @Column(name = "num_places")
    private int numPlaces;

    @OneToMany(mappedBy = "train")
    private Set<Ticket> tickets;

    @OneToMany(mappedBy = "train")
    private Set<Station> stations;


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
}
