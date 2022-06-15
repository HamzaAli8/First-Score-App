package com.livescore.app.controllers;


import com.livescore.app.elenamodel.*;
import com.livescore.app.elenaservices.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


@RestController
public class TestController {

    @Autowired
    LeagueService leagueService;

    @Autowired
    StageService stageService;

    @Autowired
    SeasonService seasonService;

    @Autowired
    AuthService authService;

    @Autowired
    PlayerService playerService;

    @Autowired
    EventService eventService;

    @Autowired
    StatService statService;

    @Autowired
    LineUpService lineUpService;

    @Autowired
    StandingService standingService;

    @Autowired
    VenueService venueService;

    @Autowired
    FixtureService fixtureService;

    @Autowired
    ApiService apiService;


//    @GetMapping(value = "/league/{id}")
//    public LeagueData League(@RequestParam(value = "expand", required = false) String expand, @PathVariable(name = "id"
//    ) Integer id) {
//
//
//        return leagueService.getLeague(id, expand);
//    }


    @GetMapping(value = "/stage/{id}")
    public StageResponse Stage(@PathVariable(name = "id"
    ) Integer id) {


        return stageService.getStageBySeasonId(id);
    }


    @GetMapping(value = "/standing/{id}")
    public StandingData getStanding(@PathVariable(name = "id"
    ) Integer id) {


        return standingService.getStandingByStageId(id);
    }


    @PostMapping(value = "/token")
    public Token getToken() {


        return authService.refreshToken();

    }

    @GetMapping(value = "/season/{id}")
    public SeasonData Season(@RequestParam(value = "expand", required = false) String expand, @PathVariable(name = "id"
    ) Integer id) {


        return seasonService.getSeasonByLeagueId(id, expand);
    }


    @GetMapping(value = "/topscorer/{id}")
    public List<TopScorerResponse> getTopScorer(@RequestParam(value = "expand", required = false) String expand, @PathVariable(name = "id"
    ) Integer id) {


        return playerService.getTopScorer(id);
    }


    @GetMapping(value = "/appearances/{id}")
    public List<PlayerResponse> getTopApps(@RequestParam(value = "expand", required = false) String expand, @PathVariable(name = "id"
    ) Integer id) {


        return playerService.getTopApps(id);
    }


    @GetMapping(value = "/event/{id}")
    public EventData getEvents(@RequestParam(value = "expand", required = false) String expand, @PathVariable(name = "id"
    ) Integer id) {


        return eventService.getEvents(id);
    }


    @GetMapping(value = "/lineup/{id}")
    public List<LineUpResponse> getLineups(@RequestParam(value = "expand", required = false) String expand, @PathVariable(name = "id"
    ) Integer id) {


        return lineUpService.getLineUpByFixtureId(id);
    }

    @GetMapping(value = "/venue/{id}")
    public VenueResponse getVenue(@RequestParam(value = "expand", required = false) @PathVariable(name = "id"
    ) Integer id) {


        return venueService.getVenueById(id);
    }

    @GetMapping(value = "/season/fixture/{id}")
    public FixtureData getFixtures(@RequestParam(value = "from", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") String date, @PathVariable(name = "id"
    ) Integer id) {


        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        localDate.format(formatter);


        return fixtureService.getFixtureBySeasonId(id, date);
    }


    @GetMapping(value = "/fixture/{id}")
    public FixtureData getFixturesById(@PathVariable(name = "id"
    ) Integer id) {


        return fixtureService.getFixtureById(id);
    }

    @GetMapping(value = "/stat/{id}")
    public StatData getStatsByFixtureId(@PathVariable(name = "id") Integer id) {


        return apiService.getStatsByFixtureId(id);
    }

//    @GetMapping(value = "/head/{id}")
//    public FixturesResponse getHeadById(@PathVariable(name = "id"
//    ) Integer id) {
//
//        return fixtureService.getHeadToHeadByFixtureId(id);
//
//
//    }

//    @GetMapping(value = "/league/{id}")
//    public LeagueResponse getLeagueById(@PathVariable(name = "id"
//    ) Integer id) {
//
//        return leagueService.getNextFixturesByLeagueId(id);
//
//
//    }

//    @GetMapping(value = "/leagueStandings/{id}")
//    public StandingResponse getStandingsById(@PathVariable(name = "id"
//    ) Integer id) {
//
//        return standingService.getLeagueStandingByStageId(id);
//
//
//    }

//    @GetMapping(value="/news")
//    public NewsResponses getNewsArticles(){
//
//
//        return apiService.getNewsArticles();
//    }

}




