package com.livescore.app.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EventResponse {

    private Integer id;
    private Integer idFixture;
    private Integer idSeason;
    private Integer idTeam;
    private String teamName;
    private Integer idplayer1;
    private String player1Name;
    private Integer idplayer2;
    private String player2Name;
    private Integer elapsed;
    private Integer elapsedPlus;
    private String type;

}
