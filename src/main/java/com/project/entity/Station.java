package com.project.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "stations")
public class Station {
    @Id
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "station_name")
    private String stationName;

//    @Column(name = "train_number")
//    private int train_number;

    @Column(name = "time")
    private Timestamp time;

    @ManyToOne
    @JoinColumn(name = "train_number", nullable = false)
    private Train train;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String station_name) {
        this.stationName = station_name;
    }

//    public int getTrain_number() {
//        return train_number;
//    }
//
//    public void setTrain_number(int train_number) {
//        this.train_number = train_number;
//    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
