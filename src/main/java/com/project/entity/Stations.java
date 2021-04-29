package com.project.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "stations")
public class Stations {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "station_name")
    private String station_name;

//    @Column(name = "train_number")
//    private int train_number;

    @Column(name = "time")
    private Timestamp time;

    @ManyToOne
    @JoinColumn(name = "train_number", nullable = false)
    private Train train;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
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
