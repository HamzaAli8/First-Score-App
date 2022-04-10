package com.livescore.app.service;

import com.livescore.app.model.TeamData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    ApiService apiService;


    public TeamData getTeamBySeasonId(Integer id, String expand){

        return apiService.getTeamById(id, expand);
    }
}
