package com.project.entity;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @Column(name = "ID")
    private int id;

//    @ManyToOne
//    @JoinColumn(name = "trainNumber")
//    private Train train;

    @Column
    private int tranNumber;

    @Column
    private int passengerId;

//    @ManyToOne
//    @JoinColumn(name = "passengerId")
//    private Passenger passenger;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public Passenger getPassenger() {
//        return passenger;
//    }

//    public Train getTrain() {
//        return train;
//    }
//
//    public void setTrain(Train train) {
//        this.train = train;
//    }

//    public void setPassenger(Passenger passenger) {
//        this.passenger = passenger;
//    }

    public int getTranNumber() {
        return tranNumber;
    }

    public void setTranNumber(int tranNumber) {
        this.tranNumber = tranNumber;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }
}
