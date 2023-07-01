package com.devatechno.irctc_client.service;

import com.devatechno.irctc_client.binding.Passenger;
import com.devatechno.irctc_client.binding.Ticket;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class BookingServiceImpl implements BookingService {
    String bookTicketUrl="http://localhost:2536/book";
    String getTicketUrl="http://localhost:2536/book/{ticketNo}";
    @Override
    public Ticket bookMyTicket(Passenger passenger) {
        /*
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<Ticket> response=restTemplate.postForEntity(bookTicketUrl,passenger, Ticket.class);
        Ticket ticket=response.getBody();
        return ticket;

         */
        WebClient webClient=WebClient.create();
           Ticket ticket=webClient.post().uri(bookTicketUrl).bodyValue(passenger).retrieve().bodyToMono(Ticket.class).block();
        return ticket;
    }

    @Override
    public Ticket getMyTicket(Integer ticketNo) {
        /*
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<Ticket> response= restTemplate.getForEntity(getTicketUrl, Ticket.class,ticketNo);
        Ticket ticket=response.getBody();
        return ticket;
         */
        WebClient webClient=WebClient.create();
        Ticket ticket=webClient.get().uri(getTicketUrl,ticketNo).retrieve().bodyToMono(Ticket.class).block();
        return ticket;
    }
}
