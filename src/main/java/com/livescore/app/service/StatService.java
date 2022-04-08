package com.livescore.app.service;

import com.livescore.app.model.StatData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class StatService {

    @Autowired
    ApiService apiService;

    public StatData getStats(Integer id, String expand){


        return apiService.getStatByFixtureId(id,expand);
    }
}
