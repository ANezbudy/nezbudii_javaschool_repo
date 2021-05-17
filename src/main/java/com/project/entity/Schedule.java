package com.project.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "trainNumber")
    private Train train;

    @ManyToOne
    @JoinColumn(name = "station_id")
    private Station station;

    @Column(name = "arrival_time")
    private Date arrivalTime;

    @Column(name = "departure_time")
    private Date departureTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date time) {
        this.arrivalTime = time;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
}
