package com.livescore.app.service;

import com.livescore.app.model.EventData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    ApiService apiService;

    public EventData getEvents(Integer id, String expand){


        return apiService.getEventByFixtureId(id,expand);
    }
}
