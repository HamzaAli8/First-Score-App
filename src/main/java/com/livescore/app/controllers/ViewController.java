package com.livescore.app.controllers;


import com.livescore.app.model.*;
import com.livescore.app.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;


@RestController
public class ViewController {

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


    @GetMapping(value = "/league/{id}")
    public LeagueData League(@RequestParam (value = "expand", required = false) String expand, @PathVariable(name = "id"
    ) Integer id) {


        return leagueService.getLeague(id,expand);
    }


    @GetMapping(value = "/stage/{id}")
    public StageData Stage(@RequestParam (value = "expand", required = false) String expand, @PathVariable(name = "id"
    ) Integer id) {


        return stageService.getStageBySeasonId(id,expand);
    }

    @PostMapping(value = "/token")
    public Token getToken() {


        return authService.refreshToken();

    }

    @GetMapping(value = "/season/{id}")
    public SeasonData Season(@RequestParam (value = "expand", required = false) String expand, @PathVariable(name = "id"
    ) Integer id) {


        return seasonService.getSeasonByLeagueId(id,expand);
    }


    @GetMapping(value = "/topscorer/{id}")
    public TopScorerData getTopScorer(@RequestParam (value = "expand", required = false) String expand, @PathVariable(name = "id"
    ) Integer id) {


        return playerService.getTopScorer(id,expand);
    }


    @GetMapping(value = "/appearances/{id}")
    public PlayerData getTopApps(@RequestParam (value = "expand", required = false) String expand, @PathVariable(name = "id"
    ) Integer id) {


        return playerService.getTopApps(id,expand);
    }



    @GetMapping(value = "/event/{id}")
    public EventData getEvents(@RequestParam (value = "expand", required = false) String expand, @PathVariable(name = "id"
    ) Integer id) {


        return eventService.getEvents(id,expand);
    }








}
