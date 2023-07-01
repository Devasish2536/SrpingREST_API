package com.devatechno.irctc_client.service;

import com.devatechno.irctc_client.binding.Passenger;
import com.devatechno.irctc_client.binding.Ticket;

public interface BookingService {
    Ticket bookMyTicket(Passenger passenger);
    Ticket getMyTicket(Integer ticketNo);
}
