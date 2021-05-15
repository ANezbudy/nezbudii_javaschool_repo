package com.project.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @OneToMany (mappedBy = "passenger", fetch = FetchType.EAGER)
    private List<Ticket> tickets;


    public List<Ticket> getTickets() {
        return tickets;
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
