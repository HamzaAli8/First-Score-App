package com.livescore.app.controllers;


import com.livescore.app.model.*;
import com.livescore.app.model.mymodels.FixtureStats;
import com.livescore.app.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MvcController {

    @Autowired
    StandingService standingService;

    @Autowired
    TeamService teamService;

    @Autowired
    FixtureService fixtureService;

    @Autowired
    StatService statService;

    @Autowired
    StageService stageService;


    @GetMapping("/index/{id}")
    public String home(Model model,@PathVariable(name = "id"
    ) Integer id){

        StandingData standings = standingService.getStandingByStageId(id);
        model.addAttribute("teams",standings);

        return "index";
    }


    @GetMapping("/fixtures/season/{id}")
    public String getFixturesBySeasonId(Model model,@RequestParam(value = "from", required = false) @DateTimeFormat(pattern="yyyy-MM-dd")  String date, @PathVariable(name = "id"
    ) Integer id){

        FixtureData fixtures = fixtureService.getFixtureBySeasonId(id, date);
        model.addAttribute("fixtures",fixtures);

       return "fixtures";
    }

    @GetMapping("/fixtures/{id}")
    public String getFixturesById(Model model, @PathVariable(name = "id"
    ) Integer id){

        FixtureData fixture = fixtureService.getFixtureById(id);
        FixturesResponse home = fixtureService.getFixtureHomeTeamById(id);
        FixturesResponse away = fixtureService.getFixtureAwayTeamById(id);
        FixtureData league = fixtureService.getFixtureLeagueById(id);
        FixturesResponse prevFixtures = fixtureService.getHeadToHeadByFixtureId(id);

        FixtureStats stats = statService.getStats(id, home.getIdHome(),away.getIdAway());


        Integer seasonId = away.getIdSeason();
        StageResponse stage = stageService.getStageBySeasonId(seasonId);
        Integer standingId = stage.getId();
        StandingData standings = standingService.getStandingByStageId(standingId);



        model.addAttribute("fixture",fixture);
        model.addAttribute("league",league);
        model.addAttribute("home",home);
        model.addAttribute("away",away);
        model.addAttribute("stats", stats);
        model.addAttribute("teams",standings);
        model.addAttribute("prevFixtures", prevFixtures);



        return "fixture-details2";
    }



}
