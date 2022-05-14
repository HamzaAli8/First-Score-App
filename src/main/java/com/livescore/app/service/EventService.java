package com.livescore.app.service;

import com.livescore.app.elenamodel.EventData;
import com.livescore.app.elenamodel.EventResponse;
import com.livescore.app.elenamodel.mymodels.FixtureEvents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EventService {

    @Autowired
    ApiService apiService;

    public EventData getEvents(Integer id) {

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


        homeTeamEvents.sort(Comparator.comparing(EventResponse::getElapsed));
        awayTeamEvents.sort(Comparator.comparing(EventResponse::getElapsed));


        return new FixtureEvents(homeTeamEvents, awayTeamEvents);

    }

}
