package com.livescore.app.elenaservices;


import com.livescore.app.elenamodel.LeagueResponse;
import com.livescore.app.elenamodel.StandingData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StandingService {

    @Autowired
    ApiService apiService;

    /**
     * This method returns the standings of the teams by passing in the stage id
     * @param id unique stage id
     * @return StandingData which is a list of StandingResponse
     */
    public StandingData getStandingByStageId(Integer id){

        return apiService.getStandingByStageId(id);
    }

    /**
     * This method returns a LeagueResponse when passing the stage id
     * @param id unique stage id
     * @return LeagueRespons
     */
    public LeagueResponse getLeagueStandingByStageId(Integer id){

        return apiService.getLeagueAndStandingByStageId(id).getData().get(0).getExpand()
               .getStage().get(0).getExpand().getSeason().get(0).getExpand().getLeague().get(0);
    }
}
