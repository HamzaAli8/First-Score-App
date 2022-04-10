package com.livescore.app.controllers;


import com.livescore.app.model.StandingData;
import com.livescore.app.model.TeamData;
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

@Controller
public class MvcController {

    @Autowired
    StandingService standingService;

    @Autowired
    TeamService teamService;


    @GetMapping("/index/{id}")
    public String home(Model model, @PathVariable Integer id, String expand){

        List<StandingData> standings = Collections.singletonList(standingService.getStandingByStageId(id, expand));
        model.addAttribute("teams",standings);

        List<TeamData> teamDataList = Collections.singletonList(teamService.getTeamBySeasonId(4120, expand));
        

        return "index";
    }
}
