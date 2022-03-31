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





}
