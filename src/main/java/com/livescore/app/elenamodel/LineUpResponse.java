package com.livescore.app.elenamodel;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LineUpResponse {

    private Integer id;
    private Integer idFixture;
    private Integer idSeason;
    private Integer idTeam;
    private String playerName;
    private Integer row;
    private String col;
    private String position;
    private String shirtNumber;
    @JsonProperty("isStartingXI")
    private boolean StartingXI;

}
