package com.project.service.impl;

import com.project.dao.api.PassengerDAO;
import com.project.dao.api.ScheduleDAO;
import com.project.dao.api.TrainDAO;
import com.project.dto.BookingDTO;
import com.project.entity.Passenger;
import com.project.entity.Schedule;
import com.project.entity.Train;
import com.project.service.api.BookingService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BookingServiceImpl implements BookingService {
    @Autowired
    TrainDAO trainDAO;

    @Autowired
    ScheduleDAO scheduleDAO;

    @Autowired
    PassengerDAO passengerDAO;

    @Override
    public long dateDiff(Date data1, Date data2, TimeUnit timeUnit) {
        long milleseconds = data2.getTime() - data1.getTime();
        return timeUnit.convert(milleseconds, TimeUnit.MILLISECONDS);
    }

    @Override
    public boolean isBookReady(int trainNumber, int scheduleId) {
        Train train = trainDAO.findTrain(trainNumber);
        Schedule schedule = scheduleDAO.findSchedule(scheduleId);

        return train.getEmptyPlaces() > 0;

    }

    @Override
    public boolean bookTheTicket(BookingDTO bookingDTO) {
        Train train = trainDAO.findTrain(bookingDTO.getTrainNumber());
        Schedule schedule = scheduleDAO.findSchedule(bookingDTO.getScheduleId());
        Passenger passenger;
        if(passengerDAO.findPassenger(bookingDTO.get))

        return false;
    }
}
