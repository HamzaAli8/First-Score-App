package com.livescore.app.elenaservices;


import com.livescore.app.elenamodel.StageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class StageService {

    @Autowired
    ApiService apiService;

    /**
     * This method returns the StageResponse of a particular season by calling the api
     * @param id unique id of the season
     * @return StageResponse
     */
    public StageResponse getStageBySeasonId(Integer id){


        return apiService.getStageBySeasonId(id).getData().get(0);
    }






}

