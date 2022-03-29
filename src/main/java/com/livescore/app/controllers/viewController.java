package com.livescore.app.controllers;


import com.livescore.app.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class viewController {

    @Autowired
    LeagueService service;


    @GetMapping("/{id}")
    public String home(@PathVariable(name = "id") Integer id, Model model){



        model.addAttribute("league", service.getLeague(id));

        return "index";
    }


}
