package com.devatechno.service;

import com.devatechno.binding.Passenger;
import com.devatechno.binding.Ticket;

public interface BookingServiceInterface {
    Ticket bookTicket(Passenger passenger);
    Ticket getTicket(Integer ticketNo);
}
