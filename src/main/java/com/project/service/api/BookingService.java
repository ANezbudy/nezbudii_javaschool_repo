package com.project.service.api;

import com.project.dto.BookingDTO;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public interface BookingService {

    boolean isBookReady(int trainNumber, int scheduleId);

    long dateDiff(Date data1, Date data2, TimeUnit timeUnit);

    boolean bookTheTicket(BookingDTO bookingDTO);
}
