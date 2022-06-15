package com.livescore.app.elenaservices;

import com.livescore.app.elenamodel.PlayerData;
import com.livescore.app.elenamodel.PlayerResponse;
import com.livescore.app.elenamodel.TopScorerData;
import com.livescore.app.elenamodel.TopScorerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    ApiService apiService;

    /**
     * Returns a list of TopScorerResponses of players based on the season that they played in
     * @param id unique season id
     * @return a list of TopScorerResponses
     */
    public List<TopScorerResponse> getTopScorer(Integer id){

        return apiService.getTopScorerBySeasonId(id).getData();
    }

    /**
     * Returns a list of TopAppearances made by a player based on the season that they played in
     * @param id unique season id
     * @return a list of TopAppearanceResponses
     */
    public List<PlayerResponse> getTopApps(Integer id){

        return apiService.getTopAppearancesBySeasonId(id).getData();
    }
}
