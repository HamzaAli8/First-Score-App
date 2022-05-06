package com.livescore.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Expand {

    private List<CountryResponse> country;
    @JsonProperty("current_season")
    private List<SeasonResponse> currentSeason;
    @JsonProperty("next_fixtures")
    private List<FixturesResponse> nextFixtures;
    @JsonProperty("seasons")
    private List<SeasonResponse> seasons;
    private List<SeasonResponse> season;
    @JsonProperty("h2h")
    private List<FixturesResponse> head2head;
    private List<TeamResponse> team;
    private List<StatResponse> stats;
    @JsonProperty("home_team")
    private List<TeamResponse> homeTeam;
    @JsonProperty("away_team")
    private List<TeamResponse> awayTeam;
    private List<LeagueResponse> league;
    private List<StageResponse> stage;





}
