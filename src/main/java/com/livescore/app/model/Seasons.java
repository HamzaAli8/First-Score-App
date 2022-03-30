package com.livescore.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Seasons {

    private Integer id;
    private Integer idLeague;
    private String leagueName;
    @JsonProperty("start")
    private Double startDate;
    @JsonProperty("end")
    private Double endDate;
}
