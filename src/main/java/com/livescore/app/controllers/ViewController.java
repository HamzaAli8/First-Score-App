package com.livescore.app.controllers;


import com.livescore.app.model.Data;
import com.livescore.app.model.Expand;
import com.livescore.app.model.LeagueResponse;
import com.livescore.app.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ViewController {

    @Autowired
    LeagueService service;


    @GetMapping(value = "/{id}")
    public Data home(@RequestParam (value = "expand", required = false) String expand, @PathVariable(name = "id"
    ) Integer id) {


        return service.getLeague(id,expand);
    }


}
