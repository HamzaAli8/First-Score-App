package com.livescore.app.service;

import com.livescore.app.elenamodel.FixtureData;
import com.livescore.app.elenamodel.FixturesResponse;
import com.livescore.app.elenamodel.LineUpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<FixturesResponse> getFixturesByTeamId(Integer id){

       List<FixturesResponse> fixtures = apiService.getFixturesByTeamId(id);

       HashSet<Object> seen = new HashSet<>();

        List<FixturesResponse> fixtureSorted = fixtures.stream()
                .filter(fixturesResponse -> seen.add(fixturesResponse.getDate()))
                .filter(fixturesResponse -> fixturesResponse.getStatus().equals("finished"))
                .collect(Collectors.toList());

       Collections.reverse(fixtureSorted);

       return fixtureSorted;
    }
}
