package com.livescore.app.service;

import com.livescore.app.elenamodel.FixtureData;
import com.livescore.app.elenamodel.FixturesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FixtureService {

    @Autowired
    ApiService apiService;

    public FixtureData getFixtureBySeasonId(Integer id, String date){

        return apiService.getFixturesBySeasonId(id,date);
    }



    public FixtureData getFixtureById(Integer id) {

        return apiService.getFixtureById(id);
    }



    public FixturesResponse getFixtureHomeTeamById(Integer id) {

        return apiService.getFixtureHomeTeamById(id).getData().get(0);


    }


    public FixturesResponse getFixtureAwayTeamById(Integer id) {

        return apiService.getFixtureAwayTeamById(id).getData().get(0);

    }

    public FixtureData getFixtureLeagueById(Integer id) {


        return apiService.getFixtureLeagueById(id);
    }

    public FixturesResponse getHeadToHeadByFixtureId(Integer id){


        return apiService.getFixtureHeadToHead(id).getData().get(0);
    }
}
