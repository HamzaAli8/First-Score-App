package com.livescore.app.elenaservices;

import com.livescore.app.elenamodel.FixtureData;
import com.livescore.app.elenamodel.FixturesResponse;
import com.livescore.app.elenamodel.LeagueResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FixtureService {

    @Autowired
    ApiService apiService;


    /**
     *  This method returns all the fixtures that have been played in a season (e.g. 20/21, 21/22)
     * @param id this the id of the season which is unique to the season being queried
     * @param date this the from date which to return the fixtures, this is immutable to match requirements
     * @return FixtureData which contains within it a list of FixtureResponses
     */
    public FixtureData getFixtureBySeasonId(Integer id, String date) {

        return apiService.getFixturesBySeasonId(id, date);
    }


    public FixtureData getFixtureById(Integer id) {

        return apiService.getFixtureById(id);
    }

    /**
     * this returns a single fixture played by a team and also the home team involved with the fixture
     * along with all relevant data.
     * @param id id of the fixture being played
     * @return a FixtureResponse
     */
    public FixturesResponse getFixtureHomeTeamById(Integer id) {

        return apiService.getFixtureHomeTeamById(id).getData().get(0);


    }

    /**
     * this returns a single fixture played by a team and also the away team involved with the fixture
     * along with all relevant data.
     * @param id unique id of the fixture being played
     * @return a FixtureResponse
     */
    public FixturesResponse getFixtureAwayTeamById(Integer id) {

        return apiService.getFixtureAwayTeamById(id).getData().get(0);

    }

    /**
     * this returns the league (e.g Premier League, La Liga) in which the fixture is being played
     * @param id unique id of the fixture being played
     * @return the LeagueResponse pertaining to the fixtureId
     */
    public LeagueResponse getFixtureLeagueById(Integer id) {


        return apiService.getFixtureLeagueById(id).getData().get(0).getExpand().getLeague().get(0);
    }


    /**
     * This method returns a list of fixtures played head to head by the teams based on the fixture id. The method parses
     * all the fixtures using the stream API and filters for the fixtures that have the status finished and reverses them
     * into a chronological orders them based on the most recently played
     * @param id fixture id of the original fixture between the teams
     * @return a list of FixtureResponses
     */
    public List<FixturesResponse> getHeadToHeadByFixtureId(Integer id) {

        List<FixturesResponse> fixtures = apiService.getFixtureHeadToHead(id).getData().get(0).getExpand().getHead2head();

        HashSet<Object> seen = new HashSet<>();

        List<FixturesResponse> fixtureSorted = fixtures.stream()
                .filter(fixturesResponse -> seen.add(fixturesResponse.getDate()))
                .filter(fixturesResponse -> fixturesResponse.getStatus().equals("finished"))
                .collect(Collectors.toList());

        Collections.reverse(fixtureSorted);

        for (FixturesResponse f : fixtureSorted) {

            fixFixtureDates(f);
        }

        return fixtureSorted;

    }

    /**
     * This method returns a list of fixtures that have been played by a team based on their id. The list of fixtureResponses
     * are then parsed using stream API to ensure that only those fixtures that have finished are returned. The fixtures are then sorted
     * into chronological order and that dates of the fixtures are formatted using the fixtureDate method
     * @param id unique id of the team
     * @return a list of FixtureResponses
     */
    public List<FixturesResponse> getResultsByTeamId(Integer id) {

        List<FixturesResponse> fixtures = apiService.getResultsByTeamId(id);

        HashSet<Object> seen = new HashSet<>();

        List<FixturesResponse> fixtureSorted = fixtures.stream()
                .filter(fixturesResponse -> seen.add(fixturesResponse.getDate()))
                .filter(fixturesResponse -> fixturesResponse.getStatus().equals("finished"))
                .collect(Collectors.toList());

        Collections.reverse(fixtureSorted);


        for (FixturesResponse f : fixtureSorted) {

            fixFixtureDates2(f);
        }


        return fixtureSorted;
    }

    /**
     * This method returns a list of fixtures that are to be played by a team based on their id. The list of fixtureResponses
     * are then parsed using stream API to ensure that only those fixtures that have not started are returned. The fixtures are then sorted
     * into chronological order and that dates of the fixtures are formatted using the fixtureDate method
     * @param id unique id of the team
     * @return a list of FixtureResponses
     */
    public List<FixturesResponse> getFixturesByTeamId(Integer id) {

        List<FixturesResponse> fixtures = apiService.getFixturesByTeamId(id);

        for (FixturesResponse f : fixtures) {

            fixFixtureDates2(f);
        }

        return fixtures.stream()
                .filter(fixturesResponse -> fixturesResponse.getStatus().equals("not started"))
                .collect(Collectors.toList());
    }

    /**
     * This method returns a FixtureResponse with the correct formatted dates so that they can be rendered correctly onto
     * the HTML page
     * @param fixtures the fixture(date) that needs to be formatted
     * @return FixtureResponses
     */
    public FixturesResponse fixFixtureDates(FixturesResponse fixtures) {
        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("EEE d MMM yyyy HH:mm:ss");
        DateTimeFormatter Old_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

            String date = newFormatter.format(Old_FORMATTER.parse(fixtures.getDate()));
            fixtures.setDate(date);

        return fixtures;
    }

    /**
     * This method returns a FixtureResponse with the correct formatted dates so that they can be rendered correctly onto
     * the HTML page
     * @param fixtures the fixture(date) that needs to be formatted
     * @return FixtureResponses
     */
    public FixturesResponse fixFixtureDates2(FixturesResponse fixtures) {
        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("EEE d MMM yyyy HH:mm:ss");
        DateTimeFormatter Old_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String date = newFormatter.format(Old_FORMATTER.parse(fixtures.getDate()));
        fixtures.setDate(date);

        return fixtures;
    }



}
