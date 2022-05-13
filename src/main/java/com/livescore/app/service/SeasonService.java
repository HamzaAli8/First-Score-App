package com.livescore.app.service;

import com.livescore.app.elenamodel.SeasonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SeasonService {


    @Autowired
    ApiService apiService;


    public SeasonData getSeasonByLeagueId(Integer id, String expand){


        return apiService.getSeasonByLeagueId(id,expand);
    }







}
