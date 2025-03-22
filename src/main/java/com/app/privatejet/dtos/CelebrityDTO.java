package com.app.privatejet.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CelebrityDTO {

    private String id;
    private String name;
    private String profession;
    private double net_worth;
    private boolean suspicious_activity;

}
