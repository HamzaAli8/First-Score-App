package com.livescore.app.service;



import com.livescore.app.model.LeagueData;
import com.livescore.app.model.LeagueResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeagueService {

    @Autowired
    ApiService apiService;

    public LeagueData getLeague(Integer id, String expand){

        return apiService.getLeagueById(id,expand);

    }

    public LeagueResponse getNextFixturesByLeagueId(Integer id){

       LeagueResponse league =  apiService.getNextFixturesByLeagueId(id).getData().get(0);

       return league;
    }

}
