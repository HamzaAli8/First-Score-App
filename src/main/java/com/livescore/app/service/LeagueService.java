package com.livescore.app.service;



import com.livescore.app.elenamodel.FixturesResponse;
import com.livescore.app.elenamodel.LeagueData;
import com.livescore.app.elenamodel.LeagueResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeagueService {

    @Autowired
    ApiService apiService;

    public LeagueData getLeague(Integer id, String expand){

        return apiService.getLeagueById(id,expand);

    }

    public List<FixturesResponse> getNextFixturesByLeagueId(Integer id){

       List<FixturesResponse> league =  apiService.getNextFixturesByLeagueId(id).getData().get(0).getExpand()
               .getSeasons().get(0).getExpand().getNextFixtures();

       return league;
    }

}
