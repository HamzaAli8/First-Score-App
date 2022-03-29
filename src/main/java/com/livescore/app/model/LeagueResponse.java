package com.livescore.app.model;


import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LeagueResponse {

    private Integer id;
    private Integer idCountry;
    private String countryName;
    private String name;
    private boolean nationalLeague;
    private boolean clubsLeague;
}
