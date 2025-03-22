package com.app.privatejet.dtos;

import com.app.privatejet.modelos.Celebrity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrivateJetDTO {

    private String id;
    private String model;
    private int capacity;
    private Celebrity celebrity;
}
