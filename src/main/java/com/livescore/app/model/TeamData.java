package com.livescore.app.model;


import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TeamData {

    private List<TeamResponse> data;


}