package com.app.privatejet.dtos;

import com.app.privatejet.modelos.Celebrity;
import com.app.privatejet.modelos.PrivateJet;
import com.app.privatejet.modelos.Purpose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FligthDTO {

    private String id;
    private Timestamp departure_time;
    private Timestamp arrival_time;
    private Purpose purpose;
    private Celebrity celebrity;
    private PrivateJet privateJet;
}
