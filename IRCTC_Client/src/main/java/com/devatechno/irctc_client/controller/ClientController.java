package com.devatechno.irctc_client.controller;

import com.devatechno.irctc_client.binding.Passenger;
import com.devatechno.irctc_client.binding.Ticket;
import com.devatechno.irctc_client.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClientController {
    @Autowired
private BookingService service;

    @GetMapping("/")
    public String loadForm(Model model){
        model.addAttribute("passenger",new Passenger());
        return "index";
    }
    @PostMapping("/book_ticket")
    public String booking(@ModelAttribute("passenger")Passenger passenger,Model model){
        Ticket ticket=service.bookMyTicket(passenger);
        model.addAttribute("msg","Booking Successful ticket no "+ticket.getTicketNo()+" is generated");
        return "index";
    }
    @GetMapping("/Ticket")
    public String getTicket(@RequestParam("ticketNo")Integer ticketNo, Model model){
        Ticket ticket=service.getMyTicket(ticketNo);
        model.addAttribute("ticket",ticket);
        return "Ticket";
    }
    @GetMapping("/getTicket")
    public String loadTicketForm(Model model){
        model.addAttribute("ticket",new Ticket());
        return "getTicket";
    }

}
