package com.project.utils;

import com.project.dto.TicketsDTO;
import com.project.entity.Ticket;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TicketMapper {
    @Autowired
    private ModelMapper mapper;

    public Ticket toEntity(TicketsDTO dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Ticket.class);
    }

    public TicketsDTO toDto(Ticket entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, TicketsDTO.class);
    }

}
