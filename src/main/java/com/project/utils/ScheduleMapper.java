package com.project.utils;

import com.project.dao.api.StationDAO;
import com.project.dao.api.TrainDAO;
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

    @Autowired
    StationDAO stationDAO;

    @Autowired
    TrainDAO trainDAO;

    public Schedule toEntity(ScheduleDTO dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Schedule.class);
    }

    public ScheduleDTO toDto(Schedule entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, ScheduleDTO.class);
    }

//    @PostConstruct
//    public void setupMapper() {
////        mapper.createTypeMap(Schedule.class, ScheduleDTO.class)
////                .addMappings(m -> m.skip(ScheduleDTO::setArrivalTime))
////                .addMappings(m -> m.skip(ScheduleDTO::setDepartureTime))
////                .setPostConverter(toDtoConverter());
//        mapper.createTypeMap(ScheduleDTO.class, Schedule.class)
//                .addMappings(m -> m.skip(Schedule::setTrain))
//                .addMappings(m -> m.skip(Schedule::setStation))
//                .setPostConverter(toEntityConverter());
//    }
//
//    public Converter<ScheduleDTO, Schedule> toEntityConverter() {
//        return context -> {
//            ScheduleDTO source = context.getSource();
//            Schedule destination = context.getDestination();
//            try {
//                mapSpecificFields(source, destination);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//            return context.getDestination();
//        };
//    }
//
////    public Converter<Schedule, ScheduleDTO> toDtoConverter() {
////        return context -> {
////            Schedule source = context.getSource();
////            ScheduleDTO destination = context.getDestination();
////            mapSpecificFields(source, destination);
////            return context.getDestination();
////        };
////    }
//
////    public void mapSpecificFields(Schedule source, ScheduleDTO destination) {
////        destination.setArrivalTime(
//////                new SimpleDateFormat("yyyy-MM-dd hh:mm").format(source.getArrivalTime())
////                source.getArrivalTime()
////        );
////        destination.setDepartureTime(
//////                new SimpleDateFormat("yyyy-MM-dd hh:mm").format(source.getDepartureTime())
////                source.getDepartureTime()
////        );
////    }
//    //TODO exception!
//    public void mapSpecificFields(ScheduleDTO source, Schedule destination) throws ParseException {
//        int trainNumber = source.getTrainNumber();
//        int stationId = source.getStationId();
//
//        destination.setTrain(trainDAO.findTrain(trainNumber));
//        destination.setStation(stationDAO.findStation(stationId));
//
//    }
}

