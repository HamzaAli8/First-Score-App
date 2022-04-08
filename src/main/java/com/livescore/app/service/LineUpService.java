package com.livescore.app.service;

import com.livescore.app.model.LineUpData;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LineUpService {

    @Autowired
    ApiService apiService;

    public LineUpData getLineUpByFixtureId(Integer id, String expand){



        return apiService.getLineUpByFixtureId(id, expand);
    }


}