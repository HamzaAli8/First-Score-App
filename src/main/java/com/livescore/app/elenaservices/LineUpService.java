package com.livescore.app.elenaservices;

import com.livescore.app.elenamodel.LineUpResponse;
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

    /**
     * This method returns a FixtureLineup entity, the method calls the external API and filters using the stream API on
     * one main property StartingXI. The stream filters the LineUpResponses for both the home and away teams and puts them
     * into two lists each for the home and away teams.
     * @param id unique fixture id
     * @param homeId unique homeTeam id
     * @param awayId unique awayTeam id
     * @return FixtureLineup
     */
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

}