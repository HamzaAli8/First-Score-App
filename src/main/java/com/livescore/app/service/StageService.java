package com.livescore.app.service;


import com.livescore.app.model.StageData;
import com.livescore.app.model.StageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class StageService {

    @Autowired
    ApiService apiService;

    public StageResponse getStageBySeasonId(Integer id){


        return apiService.getStageBySeasonId(id).getData().get(0);
    }






}

