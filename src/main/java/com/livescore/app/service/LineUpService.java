package com.livescore.app.service;

import com.livescore.app.elenamodel.EventData;
import com.livescore.app.elenamodel.EventResponse;
import com.livescore.app.elenamodel.LineUpData;
import com.livescore.app.elenamodel.LineUpResponse;
import com.livescore.app.elenamodel.mymodels.FixtureEvents;
import com.livescore.app.elenamodel.mymodels.FixtureLineup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LineUpService {

    @Autowired
    ApiService apiService;


    public FixtureLineup getLineUps(Integer id, Integer homeId, Integer awayId) {

        List<LineUpResponse> lineUpResponseList = apiService.getLineUpByFixtureId(id);
        List<LineUpResponse> lineUpList = new ArrayList<>();
        if (lineUpResponseList == null) {

            return null;

        } else {
            lineUpList = lineUpResponseList;
        }

        List<LineUpResponse> homeStartingLineUp = lineUpList.stream()
                .filter(lineUpResponse -> lineUpResponse.getIdTeam().equals(homeId))
                .filter(LineUpResponse::isStartingXI)
                .collect(Collectors.toList());

        List<LineUpResponse> awayStartingLineUp = lineUpList.stream()
                .filter(lineUpResponse -> lineUpResponse.getIdTeam().equals(awayId))
                .filter(LineUpResponse::isStartingXI)
                .distinct()
                .collect(Collectors.toList());

        List<LineUpResponse> homeSubs = lineUpList.stream()
                .filter(lineUpResponse -> lineUpResponse.getIdTeam().equals(homeId))
                .filter(lineUpResponse -> !lineUpResponse.isStartingXI())
                .collect(Collectors.toList());


        List<LineUpResponse> awaySubs = lineUpList.stream()
                .filter(lineUpResponse -> lineUpResponse.getIdTeam().equals(awayId))
                .filter(lineUpResponse -> !lineUpResponse.isStartingXI())
                .collect(Collectors.toList());

        HashSet<Object> awayLineUpSeen = new HashSet<>();

        List<LineUpResponse> finalAwayLineUp = awayStartingLineUp.stream()
                .filter(lineUpResponse -> awayLineUpSeen.add(lineUpResponse.getShirtNumber()))
                .collect(Collectors.toList());

        HashSet<Object> homeLineUpSeen = new HashSet<>();

        List<LineUpResponse> finalHomeLineUp = homeStartingLineUp.stream()
                .filter(lineUpResponse -> homeLineUpSeen.add(lineUpResponse.getShirtNumber()))
                .collect(Collectors.toList());

        HashSet<Object> homeSubSeen = new HashSet<>();

        List<LineUpResponse> finalHomeSubs = homeSubs.stream()
                .filter(lineUpResponse -> homeSubSeen.add(lineUpResponse.getShirtNumber()))
                .collect(Collectors.toList());

        HashSet<Object> awaySubsSeen = new HashSet<>();

        List<LineUpResponse> finalAwaySubs = awaySubs.stream()
                .filter(lineUpResponse -> awaySubsSeen.add(lineUpResponse.getShirtNumber()))
                .collect(Collectors.toList());

        return new FixtureLineup(finalHomeLineUp,finalAwayLineUp,finalHomeSubs,finalAwaySubs);


    }

    public List<LineUpResponse> getLineUpByFixtureId(Integer id) {

        return apiService.getLineUpByFixtureId(id);
    }
}