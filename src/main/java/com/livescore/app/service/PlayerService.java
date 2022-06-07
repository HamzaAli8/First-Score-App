package com.livescore.app.service;

import com.livescore.app.elenamodel.PlayerData;
import com.livescore.app.elenamodel.TopScorerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    ApiService apiService;


    public TopScorerData getTopScorer(Integer id, String expand){

        return apiService.getTopScorerBySeasonId(id, expand);
    }


    public PlayerData getTopApps(Integer id, String expand){

        return apiService.getTopAppearancesBySeasonId(id, expand);
    }
}
