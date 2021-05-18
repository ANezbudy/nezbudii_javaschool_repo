package com.project.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "stations")
public class Station {
    @Id
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "station_name")
    private String stationName;

    @OneToMany(mappedBy = "station", fetch = FetchType.EAGER)
    private List<Schedule> schedules;

//    @ManyToMany
//    @JoinTable(name = "schedule",
//        joinColumns = @JoinColumn (name = "station_id"),
//        inverseJoinColumns = @JoinColumn(name = "trainNumber")
//    )
//    private List<Train> trains;

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

    public List<Schedule> getSchedules() {
        return schedules;
    }
}
