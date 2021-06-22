package com.project.sbb_nau.config.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class TrainDto {
    @NotEmpty
    private int id;

    @NotEmpty
    private int trainNumber;

    @NotEmpty
    private int numPlaces;

    @NotEmpty
    private int emptyPlaces;
}
