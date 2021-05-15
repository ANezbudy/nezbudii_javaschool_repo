package com.project.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "trains")
public class Train {
    @Id
    @Column(name = "train_number")
    private int trainNumber;

    @Column(name = "num_places")
    private int numPlaces;

    @OneToMany(mappedBy = "train", fetch = FetchType.EAGER)
    private List<Ticket> tickets;

    @ManyToMany
    @JoinTable(name = "schedule",
            joinColumns = @JoinColumn (name = "train_number"),
            inverseJoinColumns = @JoinColumn(name = "station_id")
    )
    private List<Station> stations;

//    @OneToMany(mappedBy = "train")
//    private Set<Station> stations;


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

    public List<Station> getStations() {
        return stations;
    }
}
