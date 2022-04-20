package com.livescore.app.service;

import com.livescore.app.model.FixtureData;
import com.livescore.app.model.FixturesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FixtureService {

    @Autowired
    ApiService apiService;

    public FixtureData getFixtureBySeasonId(Integer id, String date){

        return apiService.getFixturesBySeasonId(id,date);
    }



    public FixturesResponse getFixtureById(Integer id) {


            return new FixturesResponse();

    }
}
