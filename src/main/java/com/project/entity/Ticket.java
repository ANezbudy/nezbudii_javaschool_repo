package com.project.entity;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @Column(name = "ID")
    private int id;

//    @Column(name = "train_number")
//    private int trainNumber;
//
//    @Column(name = "passenger_id")
//    private int passengerId;

    @ManyToOne
    @JoinColumn(name = "trainNumber")
    private Train train;

    @ManyToOne
    @JoinColumn(name = "passengerId")
    private Passenger passenger;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Passenger getPassenger() {
        return passenger;
    }
}
