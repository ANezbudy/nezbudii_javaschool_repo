package com.project.utils;

import com.project.dto.ScheduleDTO;
import com.project.entity.Schedule;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Schedule.class, ScheduleDTO.class)
                .addMappings(m -> m.skip(ScheduleDTO::setArrivalTime))
                .addMappings(m -> m.skip(ScheduleDTO::setDepartureTime))
                .setPostConverter(toDtoConverter());
        mapper.createTypeMap(ScheduleDTO.class, Schedule.class)
                .addMappings(m -> m.skip(Schedule::setArrivalTime))
                .addMappings(m -> m.skip(Schedule::setDepartureTime))
                .setPostConverter(toEntityConverter());
    }

    public Converter<ScheduleDTO, Schedule> toEntityConverter() {
        return context -> {
            ScheduleDTO source = context.getSource();
            Schedule destination = context.getDestination();
            try {
                mapSpecificFields(source, destination);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return context.getDestination();
        };
    }

    public Converter<Schedule, ScheduleDTO> toDtoConverter() {
        return context -> {
            Schedule source = context.getSource();
            ScheduleDTO destination = context.getDestination();
            mapSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    public void mapSpecificFields(Schedule source, ScheduleDTO destination) {
        destination.setArrivalTime(
                new SimpleDateFormat("yyyy-MM-dd hh:mm").format(source.getArrivalTime()).replace(' ', 'T')
        );
        destination.setDepartureTime(
                new SimpleDateFormat("yyyy-MM-dd hh:mm").format(source.getDepartureTime()).replace(' ', 'T')
        );
    }
    //TODO exception!
    public void mapSpecificFields(ScheduleDTO source, Schedule destination) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm");
        destination.setArrivalTime(format.parse(source.getArrivalTime().replace('T', ' ')));
        destination.setDepartureTime(format.parse(source.getDepartureTime().replace('T', ' ')));
    }
}

