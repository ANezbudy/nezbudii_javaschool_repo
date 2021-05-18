package com.project.utils;

import com.project.dto.TrainDTO;
import com.project.entity.Train;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TrainMapper {
    @Autowired
    private ModelMapper mapper;

    public Train toEntity(TrainDTO dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Train.class);
    }

    public TrainDTO toDto(Train entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, TrainDTO.class);
    }

}
