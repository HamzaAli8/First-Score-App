package com.livescore.app.model;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Referee {

    private String type;
    private Integer idReferee;
    private String refereeName;
}
