package com.devatechno.irctc_client.binding;

import lombok.Data;

@Data
public class Passenger {
    private String name;
    private Integer age;
    private String gender;
    private String from;
    private String to;
    private Integer trainNo;
    private String doj;
}
