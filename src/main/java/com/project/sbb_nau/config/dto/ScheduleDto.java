package com.project.sbb_nau.config.dto;

import com.project.sbb_nau.entity.Station;
import com.project.sbb_nau.entity.Train;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class ScheduleDto {
    @NotEmpty
    private int id;

    @NotEmpty
    private Date arrivalTime;

    @NotEmpty
    private Date departureTime;

    @NotEmpty
    private Station station;

    @NotEmpty
    private Train train;
}
