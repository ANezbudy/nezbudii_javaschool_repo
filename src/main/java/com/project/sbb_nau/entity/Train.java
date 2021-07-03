package com.project.sbb_nau.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "trains")
@Data
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(nullable = false, unique = true)
    public Integer trainNumber;

    @Column
    private Integer numPlaces;

    @Column
    private Integer emptyPlaces;

}
