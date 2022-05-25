package com.livescore.app.service;

import com.livescore.app.elenamodel.FixtureData;
import com.livescore.app.elenamodel.FixturesResponse;
import com.livescore.app.elenamodel.LineUpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FixtureService {

    @Autowired
    ApiService apiService;

    public FixtureData getFixtureBySeasonId(Integer id, String date) {

        return apiService.getFixturesBySeasonId(id, date);
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

    public FixturesResponse getHeadToHeadByFixtureId(Integer id) {

        FixturesResponse fixture = apiService.getFixtureHeadToHead(id).getData().get(0);

        fixture = fixFixtureDates(fixture);

        return fixture;

    }

    public List<FixturesResponse> getResultsByTeamId(Integer id) {

        List<FixturesResponse> fixtures = apiService.getResultsByTeamId(id);

        HashSet<Object> seen = new HashSet<>();

        List<FixturesResponse> fixtureSorted = fixtures.stream()
                .filter(fixturesResponse -> seen.add(fixturesResponse.getDate()))
                .filter(fixturesResponse -> fixturesResponse.getStatus().equals("finished"))
                .collect(Collectors.toList());


        for (FixturesResponse f : fixtures) {

            fixFixtureDates(f);
        }


        Collections.reverse(fixtureSorted);

        return fixtureSorted;
    }

    public List<FixturesResponse> getFixturesByTeamId(Integer id) {

        List<FixturesResponse> fixtures = apiService.getFixturesByTeamId(id);

        for (FixturesResponse f : fixtures) {

            fixFixtureDates(f);
        }

        return fixtures.stream()
                .filter(fixturesResponse -> fixturesResponse.getStatus().equals("not started"))
                .collect(Collectors.toList());
    }

    public FixturesResponse fixFixtureDates(FixturesResponse fixtures) {
        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("EEEE, d MMM yyyy HH:mm:ss");
        DateTimeFormatter Old_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        DateTimeFormatter Old_FORMATTER2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        if (fixtures.getExpand() != null) {

            fixtures.getExpand().getHead2head()
                    .forEach(f -> {
                        String date = newFormatter.format(Old_FORMATTER.parse(f.getDate()));
                        f.setDate(date);
                    });
        } else {
            String date = newFormatter.format(Old_FORMATTER2.parse(fixtures.getDate()));
            fixtures.setDate(date);
        }
        return fixtures;
    }

}
