package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "passengers")
public class Passenger {
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "name")
    private String passengerName;

    @Column(name = "lastname")
    private String passengerLastName;

    @Column(name = "birthdate")
    private Date passengerBirthDate;

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
