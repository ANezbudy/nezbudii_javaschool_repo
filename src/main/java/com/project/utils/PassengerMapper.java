package com.project.utils;

import com.project.dto.PassengerDTO;
import com.project.entity.Passenger;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;

@Component
public class PassengerMapper {
    @Autowired
    private ModelMapper mapper;

    public Passenger toEntity(PassengerDTO dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Passenger.class);
    }

    public PassengerDTO toDto(Passenger entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, PassengerDTO.class);
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Passenger.class, PassengerDTO.class)
                .addMappings(m -> m.skip(PassengerDTO::setPassengerBirthDate)).setPostConverter(toDtoConverter());
        mapper.createTypeMap(PassengerDTO.class, Passenger.class)
                .addMappings(m -> m.skip(Passenger::setPassengerBirthDate)).setPostConverter(toEntityConverter());
    }

    public Converter<PassengerDTO, Passenger> toEntityConverter() {
        return context -> {
            PassengerDTO source = context.getSource();
            Passenger destination = context.getDestination();
            try {
                mapSpecificFields(source, destination);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return context.getDestination();
        };
    }

    public Converter<Passenger, PassengerDTO> toDtoConverter() {
        return context -> {
            Passenger source = context.getSource();
            PassengerDTO destination = context.getDestination();
            mapSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    // will convert the data from DB to view in a needed format
    public void mapSpecificFields(Passenger source, PassengerDTO destination) {
        destination.setPassengerBirthDate(
                new SimpleDateFormat("yyyy-MM-dd").format(source.getPassengerBirthDate())
        );
    }

    // will convert the data from view to DTO in a needed format. Not sure if it is needed
    public void mapSpecificFields(PassengerDTO source, Passenger destination) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
        destination.setPassengerBirthDate(format.parse(source.getPassengerBirthDate()));
    }


}
