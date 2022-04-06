package com.livescore.app.service;


import com.livescore.app.model.StageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class StageService {

    @Autowired
    ApiService apiService;

    public StageData getStageBySeasonId(Integer id, String expand){


        return apiService.getStageBySeasonId(id,expand);
    }






}

