package com.livescore.app.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class VenueResponse {


    private Integer id;
    private String name;
    private Integer capacity;
    private String city;

}
