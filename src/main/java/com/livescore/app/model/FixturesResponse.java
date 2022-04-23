package com.livescore.app.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FixturesResponse {

    private Integer id;
    private Integer idCountry;
    private String countryName;
    private Integer idLeague;
    private String leagueName;
    private Integer idSeason;
    private String seasonName;
    private Integer idHome;
    private String homeName;
    private Integer idAway;
    private String awayName;
    private Integer idStage;
    private Integer idVenue;
    private String venueName;
    private String date;
    private String status;
    private Integer round;
    private Integer attendance;
    @JsonProperty("team_home_90min_goals")
    private Integer homeTeamGoals;
    @JsonProperty("team_away_90min_goals")
    private Integer awayTeamGoals;
    private Integer team_home_ET_goals;
    private Integer team_away_ET_goals;
    private Integer team_home_PEN_goals;
    private Integer team_away_PEN_goals;
    private Integer team_home_1stHalf_goals;
    private Integer team_away_1stHalf_goals;
    private Integer team_away_2ndHalf_goals;
    private Integer elapsed;
    private Integer elapsedPlus;
    private String eventsHash;
    private String lineupsHash;
    private String statsHash;
    private Referee [] referees;
    private Expand expand;
}
