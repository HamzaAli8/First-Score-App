package com.livescore.app.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Data {

    private List<LeagueResponse> data;
}
