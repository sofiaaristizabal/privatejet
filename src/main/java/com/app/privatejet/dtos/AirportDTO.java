package com.app.privatejet.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirportDTO {

    private String id;
    private String name;
    private String location;
    private int capacity;
    private String owners;

}
