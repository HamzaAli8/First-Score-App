package com.livescore.app.controllers;


import com.livescore.app.model.*;
import com.livescore.app.service.FixtureService;
import com.livescore.app.service.StandingService;
import com.livescore.app.service.TeamService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Controller
public class MvcController {

    @Autowired
    StandingService standingService;

    @Autowired
    TeamService teamService;

    @Autowired
    FixtureService fixtureService;


    @GetMapping("/index/{id}")
    public String home(Model model, @RequestParam(value = "expand", required = false) String expand, @PathVariable(name = "id"
    ) Integer id){

        StandingData standings = standingService.getStandingByStageId(id, expand);
        model.addAttribute("teams",standings);

        TeamData teamData = teamService.getTeamBySeasonId(4210, expand);



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
        FixtureData home = fixtureService.getFixtureHomeTeamById(id);
        FixtureData away = fixtureService.getFixtureAwayTeamById(id);
        FixtureData league = fixtureService.getFixtureLeagueById(id);



        model.addAttribute("fixture",fixture);
        model.addAttribute("league",league);
        model.addAttribute("home",home);
        model.addAttribute("away",away);




        return "fixture-details";
    }






}
