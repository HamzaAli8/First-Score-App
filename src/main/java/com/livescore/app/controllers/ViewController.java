package com.livescore.app.controllers;


import com.livescore.app.model.LeagueData;
import com.livescore.app.model.SeasonData;
import com.livescore.app.model.StageData;
import com.livescore.app.service.LeagueService;
import com.livescore.app.service.SeasonService;
import com.livescore.app.service.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ViewController {

    @Autowired
    LeagueService leagueService;

    @Autowired
    StageService stageService;

    @Autowired
    SeasonService seasonService;


    @GetMapping(value = "/league/{id}")
    public LeagueData League(@RequestParam (value = "expand", required = false) String expand, @PathVariable(name = "id"
    ) Integer id) {


        return leagueService.getLeague(id,expand);
    }


    @GetMapping(value = "/stage/{id}")
    public StageData Stage(@RequestParam (value = "expand", required = false) String expand, @PathVariable(name = "id"
    ) Integer id) {


        return stageService.getStage(id);
    }

    @PostMapping(value = "/token")
    public String getToken() {


        return leagueService.getToken();
    }


    @GetMapping(value = "/season/{id}")
    public SeasonData Season(@RequestParam (value = "expand", required = false) String expand, @PathVariable(name = "id"
    ) Integer id) {


        return seasonService.getSeasonByLeagueId(id,expand);
    }






}
