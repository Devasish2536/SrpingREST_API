package com.devatechno.controller;

import com.devatechno.binding.Passenger;
import com.devatechno.binding.Ticket;
import com.devatechno.service.BookingServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {
    @Autowired
    public BookingServiceInterface service;
    @PostMapping(value = "/book", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Ticket>bookTicket(@RequestBody Passenger passenger){
        Ticket ticket=service.bookTicket(passenger);
        System.out.println(ticket);
        return new ResponseEntity<>(ticket, HttpStatus.CREATED);
    }
    @GetMapping(value = "/book/{ticketNo}",produces = "application/json")
    public Ticket getTicket(@PathVariable Integer ticketNo){
        Ticket ticket=service.getTicket(ticketNo);
        System.out.println(ticket);
        return ticket;
    }
}
