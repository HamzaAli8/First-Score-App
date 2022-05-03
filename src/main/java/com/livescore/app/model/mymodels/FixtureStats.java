package com.livescore.app.model.mymodels;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FixtureStats {

    private Map<String,Integer> homeTeam;
    private Map<String, Integer> awayTeam;
}
