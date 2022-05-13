package com.livescore.app.elenamodel;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LeagueData {

    private List<LeagueResponse> data;
}
