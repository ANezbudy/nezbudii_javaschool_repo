package com.project.sbb_nau.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "stations")
@Getter
@Setter
@NoArgsConstructor
public class Station {
    @Id
    private int id;

    @NotBlank
    private String stationName;

//    @OneToMany(mappedBy = "station", fetch = FetchType.EAGER)
//    private List<Schedule> schedules;
}
