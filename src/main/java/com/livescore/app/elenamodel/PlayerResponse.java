package com.livescore.app.elenamodel;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlayerResponse {

    private Integer idPlayer;
    private String playerName;
    private Integer tot;
    private Integer rank;
    private Expand expand;

}
