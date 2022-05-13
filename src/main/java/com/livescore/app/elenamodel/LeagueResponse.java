package com.livescore.app.elenamodel;


import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LeagueResponse {

    private Integer id;
    private Integer idCountry;
    private String countryName;
    private String name;
    private boolean nationalLeague;
    private boolean clubsLeague;
    private Expand expand;
}
