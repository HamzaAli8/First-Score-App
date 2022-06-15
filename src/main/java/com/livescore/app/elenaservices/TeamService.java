package com.livescore.app.elenaservices;

import com.livescore.app.elenamodel.TeamResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    ApiService apiService;

    /**
     * This returns a TeamResponse based on the teamId that is passed as a parameter
     * @param id unique id of the team
     * @return TeamResponse
     */
    public TeamResponse getTeamById(Integer id){

        return apiService.getTeamById(id).getData().get(0);
    }

}

