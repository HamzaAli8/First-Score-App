package com.livescore.app.model.mymodels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FixtureEvents {

    private Map<Integer,String> homeTypeElapsed;
    private Map<Integer, String> awayTypeElapsed;
    private Map<Integer, String> homePlayers;
    private Map<Integer, String> awayPlayers;
}
