package com.devatechno.service;

import com.devatechno.binding.Passenger;
import com.devatechno.binding.Ticket;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class BookingServiceImpl implements BookingServiceInterface{
    private Map<Integer,Ticket>ticketMap=new HashMap<>();
    @Override
    public Ticket bookTicket(Passenger passenger) {
        Ticket ticket=new Ticket();
        BeanUtils.copyProperties(passenger,ticket);
        ticket.setTicketNo(5678);
        ticket.setCost(1960.50);
        ticket.setStatus("confirmed s7-28");
        ticketMap.put(ticket.getTicketNo(), ticket);
        return ticket;

    }

    @Override
    public Ticket getTicket(Integer ticketNo) {
        Ticket ticket=ticketMap.get(ticketNo);
        return ticket;
    }
}
