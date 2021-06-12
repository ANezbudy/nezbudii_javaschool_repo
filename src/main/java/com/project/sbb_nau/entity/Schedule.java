package com.project.sbb_nau.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="schedule")
@Data
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer scheduleId;

//    @Column
//    public Integer stationId;

    @Column
    public Date arrivalTime;

    @Column
    public Date departureTime;

//    @Column
//    public Integer trainNumber;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Station station;

    @ManyToOne
    @JoinColumn(name = "trainNumber", nullable = false)
    private Station train;


}
