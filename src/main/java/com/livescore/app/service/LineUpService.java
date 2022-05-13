package com.livescore.app.service;

import com.livescore.app.elenamodel.LineUpData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LineUpService {

    @Autowired
    ApiService apiService;

    public LineUpData getLineUpByFixtureId(Integer id){


        return apiService.getLineUpByFixtureId(id);
    }


}