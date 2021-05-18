package com.project.service.impl;

import com.project.dao.api.PassengerDAO;
import com.project.dao.api.ScheduleDAO;
import com.project.dao.api.TicketDAO;
import com.project.dao.api.TrainDAO;
import com.project.dto.BookingDTO;
import com.project.entity.Passenger;
import com.project.entity.Schedule;
import com.project.entity.Ticket;
import com.project.entity.Train;
import com.project.service.api.BookingService;
import com.project.service.api.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    TrainDAO trainDAO;

    @Autowired
    ScheduleDAO scheduleDAO;

    @Autowired
    PassengerDAO passengerDAO;

    @Autowired
    TicketDAO ticketDAO;

    @Autowired
    PassengerService passengerService;

    @Override
    public long dateDiff(Date data1, Date data2, TimeUnit timeUnit) {
        long milleseconds = data2.getTime() - data1.getTime();
        return timeUnit.convert(milleseconds, TimeUnit.MILLISECONDS);
    }

    @Override
    public boolean isBookReady(String trainNumber, String scheduleId) {
        int trainNumberInt = Integer.parseInt(trainNumber);
        int scheduleIdInt = Integer.parseInt(scheduleId);
        Train train = trainDAO.findTrain(trainNumberInt);
        Schedule schedule = scheduleDAO.findSchedule(scheduleIdInt);
        return train.getEmptyPlaces() > 0;
    }

    @Override
    public String bookTheTicket(BookingDTO bookingDTO) {
        Train train = trainDAO.findTrain(bookingDTO.getTrainNumber());
        Schedule schedule = scheduleDAO.findSchedule(bookingDTO.getScheduleId());
        Passenger passenger = passengerDAO.findPassenger(
                bookingDTO.getPassengerName(),
                bookingDTO.getPassengerLastName(),
                bookingDTO.getPassengerBirthDate());

        if (passenger == null) { //no such passenger
            Passenger newPassenger = passengerDAO.createPassenger(
                    bookingDTO.getPassengerName(),
                    bookingDTO.getPassengerLastName(),
                    bookingDTO.getPassengerBirthDate()
            );

            int ticketId = ticketDAO.createTicket(newPassenger, train.getTrainNumber());
            trainDAO.changeEmptyPlaces(train.getTrainNumber(), train.getNumPlaces() - 1);
            return "The ticket booked. Ticket number: " + ticketId;
        } else {//there is a passenger

            //need to check if there are tickets for him
            List<Ticket> ticketsForPassenger = ticketDAO.findTrainTickets(bookingDTO.getTrainNumber())
                    .stream().map(ticket -> {
                        if (ticket.getPassengerId() == passenger.getId()) {
                            return ticket;
                        } else return null;
                    }).collect(Collectors.toList());


            if (ticketsForPassenger.size() == 0) {//there are no tickets in the train for passenger
                int ticketId = ticketDAO.createTicket(passenger, train.getTrainNumber());
                trainDAO.changeEmptyPlaces(train.getTrainNumber(), train.getNumPlaces() - 1);
                return "The ticket booked. Ticket number: " + ticketId;
            } else { //there are tickets in the train for passenger
                return "The passenger already registered on the train!";
            }
        }
    }
}
