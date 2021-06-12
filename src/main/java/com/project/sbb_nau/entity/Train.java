package com.project.sbb_nau.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "trains")
@Data
public class Train {

    @Id
    public Integer trainNumber;

    @Column
    private Integer numPlaces;

    @Column
    private Integer emptyPlaces;

    @OneToMany(mappedBy = "train", fetch = FetchType.EAGER)
    private List<Schedule> schedules;
}
