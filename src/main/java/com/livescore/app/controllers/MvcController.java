package com.livescore.app.controllers;


import com.livescore.app.model.StandingData;
import com.livescore.app.model.StandingResponse;
import com.livescore.app.model.TeamData;
import com.livescore.app.model.TeamResponse;
import com.livescore.app.service.StandingService;
import com.livescore.app.service.TeamService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

@Controller
public class MvcController {

    @Autowired
    StandingService standingService;

    @Autowired
    TeamService teamService;


    @GetMapping("/index/{id}")
    public String home(Model model, @PathVariable Integer id, String expand){

        StandingData standings = standingService.getStandingByStageId(id, expand);
        model.addAttribute("teams",standings);

        TeamData teamData = teamService.getTeamBySeasonId(4210, expand);



        return "index";
    }
}
