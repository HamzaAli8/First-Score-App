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
    @JsonProperty("season")
    private List<SeasonResponse> season;
    @JsonProperty("h2h")
    private List<FixturesResponse> head2head;
    private List<TeamResponse> team;
    private List<StatResponse> stats;

}
