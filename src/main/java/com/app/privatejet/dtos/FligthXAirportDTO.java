package com.app.privatejet.dtos;

import com.app.privatejet.modelos.Airport;
import com.app.privatejet.modelos.Fligth;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FligthXAirportDTO {

    private String id;
    private Fligth fligth;
    private Airport departure_airport;
    private Airport arrival_airport;
}
