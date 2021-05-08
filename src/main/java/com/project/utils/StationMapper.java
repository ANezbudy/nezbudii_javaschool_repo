package com.project.utils;

import com.project.dto.StationDTO;
import com.project.dto.TrainDTO;
import com.project.entity.Station;
import com.project.entity.Train;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class StationMapper {
    @Autowired
    private ModelMapper mapper;

    public Station toEntity(StationDTO dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Station.class);
    }

    public StationDTO toDto(Station entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, StationDTO.class);
    }

}
