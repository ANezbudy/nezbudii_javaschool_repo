package com.project.entity;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @Column(name = "ID")
    private int id;

    @Column
    private int trainNumber;

    @Column
    private int passengerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }
}
