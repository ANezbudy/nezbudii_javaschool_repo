package com.project.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "passengers")
public class Passenger {
    @Id
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String passengerName;

    @Column(name = "lastname", nullable = false)
    private String passengerLastName;

    @Column(name = "birthdate", nullable = false)
    private Date passengerBirthDate;

    @OneToOne(mappedBy = "passenger")
    private Tickets ticket;

    public Tickets getTicket() {
        return ticket;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerLastName() {
        return passengerLastName;
    }

    public void setPassengerLastName(String passengerLastName) {
        this.passengerLastName = passengerLastName;
    }

    public Date getPassengerBirthDate() {
        return passengerBirthDate;
    }

    public void setPassengerBirthDate(Date passengerBirthDate) {
        this.passengerBirthDate = passengerBirthDate;
    }

    public int getId() {
        return id;
    }
}
