package com.devatechno.binding;

import lombok.Data;

@Data
public class Ticket {
    private Integer ticketNo;
    private Double cost;
    private String status;
    private String name;
    private String age;
    private String gender;
    private String from;
    private String to;
    private Integer trainNo;
    private String doj;
}
