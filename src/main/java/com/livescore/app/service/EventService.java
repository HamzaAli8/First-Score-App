package com.livescore.app.service;

import com.livescore.app.model.EventData;
import com.livescore.app.model.EventResponse;
import com.livescore.app.model.mymodels.FixtureEvents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.Map;

@Service
public class EventService {

    @Autowired
    ApiService apiService;

    public EventData getEvents(Integer id){

        return apiService.getEventByFixtureId(id);
    }


    public FixtureEvents getStats(Integer id, Integer homeId, Integer awayId) {

        EventData eventData = apiService.getEventByFixtureId(id);
        List<EventResponse> eventList = new ArrayList<>();
        if (eventData == null) {

            return null;

        } else {
            eventList = eventData.getData();
        }

       List<EventResponse> homeTeamEvents = eventList.stream()
                .filter(eventResponse -> eventResponse.getIdTeam().equals(homeId))
                .collect(Collectors.toList());


        List<EventResponse> awayTeamEvents = eventList.stream()
                .filter(eventResponse -> eventResponse.getIdTeam().equals(awayId))
                .collect(Collectors.toList());




        return new FixtureEvents(homeTeamEvents,awayTeamEvents);

    }

}
