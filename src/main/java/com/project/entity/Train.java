package com.project.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "trains")
public class Train {
    @Id
    @Column(name = "train_number")
    private int train_number;

    @Column(name = "num_places")
    private int num_places;

    @OneToMany(mappedBy = "train")
    private Set<Tickets> tickets;

    @OneToMany(mappedBy = "train")
    private Set<Stations> stations;


    public int getTrain_number() {
        return train_number;
    }

    public void setTrain_number(int train_number) {
        this.train_number = train_number;
    }

    public int getNum_places() {
        return num_places;
    }

    public void setNum_places(int num_places) {
        this.num_places = num_places;
    }
}
