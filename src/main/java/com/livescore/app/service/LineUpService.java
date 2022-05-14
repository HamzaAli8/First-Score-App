package com.livescore.app.service;

import com.livescore.app.elenamodel.LineUpData;
import com.livescore.app.elenamodel.LineUpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineUpService {

    @Autowired
    ApiService apiService;

    public List<LineUpResponse> getLineUpByFixtureId(Integer id){


        return apiService.getLineUpByFixtureId(id);
    }


}