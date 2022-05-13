package com.livescore.app.elenamodel;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StatResponse {

    private Integer id;
    private Integer idFixture;
    private Integer idSeason;
    private Integer idTeam;
    private String teamName;
    private String label;
    private Integer value;

}
