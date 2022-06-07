package com.livescore.app.service;


import com.livescore.app.elenamodel.LeagueResponse;
import com.livescore.app.elenamodel.StandingData;
import com.livescore.app.elenamodel.StandingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StandingService {

    @Autowired
    ApiService apiService;

    public StandingData getStandingByStageId(Integer id){

        return apiService.getStandingByStageId(id);
    }

    public LeagueResponse getLeagueStandingByStageId(Integer id){

        return apiService.getLeagueAndStandingByStageId(id).getData().get(0).getExpand()
               .getStage().get(0).getExpand().getSeason().get(0).getExpand().getLeague().get(0);
    }
}
