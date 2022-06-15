package com.livescore.app.elenaservices;

import com.livescore.app.elenamodel.SeasonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SeasonService {


    @Autowired
    ApiService apiService;

    /**
     * This returns the SeasonData of the season being played based on the league id
     * @param id unique league id
     * @return SeasonData which has a list of SeasonResponses contained within it
     */
    public SeasonData getSeasonByLeagueId(Integer id){

        return apiService.getSeasonByLeagueId(id);
    }







}
