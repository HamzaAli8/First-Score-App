package com.livescore.app.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TopScorerResponse {

    private Integer idPlayer;
    private String playerName;
    private Integer totalGoals;
    private Integer penaltiesScored;
    private Integer penaltiesMissed;
    private Integer rank;
    private Expand expand;

}
