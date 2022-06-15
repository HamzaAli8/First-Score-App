package com.livescore.app.elenaservices;



import com.livescore.app.elenamodel.FixturesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeagueService {

    @Autowired
    ApiService apiService;

    /**
     * Returns a the fixtures that are to be played in a particular league
     * @param id the league id
     * @return a list of FixtureResponses to be played in league
     */
    public List<FixturesResponse> getNextFixturesByLeagueId(Integer id){

       List<FixturesResponse> league =  apiService.getNextFixturesByLeagueId(id).getData().get(0).getExpand()
               .getSeasons().get(0).getExpand().getNextFixtures();

       return league;
    }

}
