package com.project.utils;

import com.project.dto.TicketsDTO;
import com.project.entity.Tickets;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TicketMapper {
    @Autowired
    private ModelMapper mapper;

    public Tickets toEntity(TicketsDTO dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Tickets.class);
    }

    public TicketsDTO toDto(Tickets entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, TicketsDTO.class);
    }

}
