package com.livescore.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Standing {

    private Integer idStage;
    private Integer idTeam;
    private String teamName;
    @JsonProperty("ga")
    private Integer goalsAgainst;
    @JsonProperty("ga_away")
    private Integer goalsAgainstAway;
    @JsonProperty("ga_home")
    private Integer goalsAgainstHome;
    @JsonProperty("gf")
    private Integer goalsFor;
    @JsonProperty("gf_away")
    private Integer goalsForAway;
    @JsonProperty("gf_home")
    private Integer goalsForHome;
    @JsonProperty("gd")
    private Integer goalDifference;
    @JsonProperty("gd_away")
    private Integer goalDifferenceAway;
    @JsonProperty("gd_home")
    private Integer goalDifferenceHome;
    @JsonProperty("p")
    private Integer gamesPlayed;
    @JsonProperty("p_away")
    private Integer awayGamesPlayed;
    @JsonProperty("p_home")
    private Integer homeGamesPlayed;
    @JsonProperty("w")
    private Integer gamesWon;
    @JsonProperty("w_away")
    private Integer gamesWonAway;
    @JsonProperty("w_homes")
    private Integer gamesWonHome;
    @JsonProperty("d")
    private Integer gamesDrawn;
    @JsonProperty("d_away")
    private Integer gamesDrawnAway;
    @JsonProperty("d_home")
    private Integer gamesDrawnHome;
    @JsonProperty("l")
    private Integer gamesLost;
    @JsonProperty("l_away")
    private Integer gamesLostAway;
    @JsonProperty("l_home")
    private Integer gamesLostHome;
    @JsonProperty("pts")
    private Integer points;
    @JsonProperty("pts_away")
    private Integer pointsAway;
    @JsonProperty("pts_home")
    private Integer pointsHome;
    @JsonProperty("pos")
    private Integer ranking;
    @JsonProperty("note")
    private String notes;







}
