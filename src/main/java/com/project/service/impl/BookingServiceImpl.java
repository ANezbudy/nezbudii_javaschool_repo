package com.project.service.impl;

import com.project.dao.api.PassengerDAO;
import com.project.dao.api.ScheduleDAO;
import com.project.dao.api.TicketDAO;
import com.project.dao.api.TrainDAO;
import com.project.dto.BookingDTO;
import com.project.entity.Passenger;
import com.project.entity.Train;
import com.project.service.api.BookingService;
import com.project.service.api.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

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
        long milliseconds = data2.getTime() - data1.getTime();
        return timeUnit.convert(milliseconds, TimeUnit.MILLISECONDS);
    }

    @Override
    public boolean isEmptyPlacesOnTrain(int trainNumber) {
        Train train = trainDAO.findTrain(trainNumber);
        return train.getEmptyPlaces() > 0;
    }

    @Override
    public String bookTicket(BookingDTO bookingDTO) {
        //data part
        int trainNumber = bookingDTO.getTrainNumber();
        int scheduleId = bookingDTO.getScheduleId();
        Date departureTime = bookingDTO.getDepartureTime();
        String pName = bookingDTO.getPassengerName();
        String pLastName = bookingDTO.getPassengerLastName();
        Date pBirthDate = bookingDTO.getPassengerBirthDate();
        /******************************************************/
        //var
        Date regDate = new Date();
        int ticketNumber;
        //////////////////////////////////
        //check if there is empty places on train - no need to do something
        if (!isEmptyPlacesOnTrain(trainNumber)) {
            return  "There are no places on train!";
        }
        //check the time - 10 minutes before departure -  - no need to do something
        if (!departureTime.after(regDate) && dateDiff(regDate, departureTime, TimeUnit.MINUTES) < 10) {
            return "Too late! Less then 10 minutes before departure";
        }
        //check if the passenger not registered on train - there is no ticket for such passenger id and train number
            //get the passenger id - find passenger by name, last name and date
        Passenger passenger = passengerDAO.findPassenger(pName, pLastName, pBirthDate);
                //if there is no such passenger
        if(passenger == null) {
            //create passsenger
            passengerDAO.createPassenger(pName, pLastName, pBirthDate);
            //create ticket with train number and pass id
            Passenger newPassenger = passengerDAO.findPassenger(pName, pLastName, pBirthDate);
            ticketDAO.createTicket(newPassenger.getId(), trainNumber);
            ticketNumber = ticketDAO.findTrainAndPassengerTickets(trainNumber, newPassenger.getId()).get(0).getId();
        } else { //if there is a passenger
            //check if there is a ticket with the PassengerID and TrainNumber
            if (ticketDAO.findTrainAndPassengerTickets(trainNumber, passenger.getId()).size() > 0) {
                return "The passenger already registered on train!";
            } else {//if no create ticket
                ticketDAO.createTicket(passenger.getId(), trainNumber);
                ticketNumber = ticketDAO.findTrainAndPassengerTickets(trainNumber, passenger.getId()).get(0).getId();
            }
        }
        return "The passenger registered. Ticket number is " + ticketNumber;
    }

}
