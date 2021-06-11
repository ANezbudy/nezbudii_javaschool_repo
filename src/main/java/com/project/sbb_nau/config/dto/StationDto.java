package com.project.sbb_nau.config.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class StationDto {
    @NotEmpty
    private int id;

    @NotEmpty
    private String stationName;
}
