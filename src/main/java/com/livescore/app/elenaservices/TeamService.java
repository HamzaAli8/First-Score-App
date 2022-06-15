package com.livescore.app.elenaservices;

import com.livescore.app.elenamodel.TeamResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    ApiService apiService;


    public TeamResponse getTeamById(Integer id){

        return apiService.getTeamById(id).getData().get(0);
    }

}

