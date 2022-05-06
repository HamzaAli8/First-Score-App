package com.livescore.app.service;


import com.livescore.app.model.StandingData;
import com.livescore.app.model.StandingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StandingService {

    @Autowired
    ApiService apiService;


    public StandingData getStandingByStageId(Integer id){


        return apiService.getStandingByStageId(id);
    }

    public StandingResponse getLeagueStandingByStageId(Integer id){


        return apiService.getLeagueAndStandingByStageId(id).getData().get(0);
    }
}
