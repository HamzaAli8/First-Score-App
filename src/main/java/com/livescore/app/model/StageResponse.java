package com.livescore.app.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StageResponse {

    private Integer id;
    private Integer idSeason;
    private String name;
    private boolean hasStanding;
    Expand expand;

}
