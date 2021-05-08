package com.project.utils;

import com.project.dto.ScheduleDTO;
import com.project.entity.Schedule;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ScheduleMapper {
    @Autowired
    private ModelMapper mapper;

    public Schedule toEntity(ScheduleDTO dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Schedule.class);
    }

    public ScheduleDTO toDto(Schedule entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, ScheduleDTO.class);
    }
}
