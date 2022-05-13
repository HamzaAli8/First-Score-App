package com.livescore.app.elenamodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SeasonResponse {

    private Integer id;
    private Integer idLeague;
    private String leagueName;
    @JsonProperty("start")
    private Double startDate;
    @JsonProperty("end")
    private Double endDate;
    Expand expand;
}
