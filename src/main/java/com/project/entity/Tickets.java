package com.project.entity;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
public class Tickets {
    @Id
    @Column(name = "ID")
    private int id;

//    @Column(name = "train_number")
//    private int train_number;

//    @Column(name = "passenger_id")
//    private int passenger_id;

    @ManyToOne
    @JoinColumn(name = "train_number", nullable = false)
    private Train train;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passenger_id", referencedColumnName = "ID", insertable = false, updatable = false)
    private Passenger passenger;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public int getTrain_number() {
//        return train_number;
//    }
//
//    public void setTrain_number(int train_number) {
//        this.train_number = train_number;
//    }
//
//    public int getPassenger_id() {
//        return passenger_id;
//    }
//
//    public void setPassenger_id(int passenger_id) {
//        this.passenger_id = passenger_id;
//    }
}
