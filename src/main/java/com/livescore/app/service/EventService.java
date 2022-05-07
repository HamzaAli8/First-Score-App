package com.livescore.app.service;

import com.livescore.app.model.EventData;
import com.livescore.app.model.EventResponse;
import com.livescore.app.model.StatData;
import com.livescore.app.model.StatResponse;
import com.livescore.app.model.mymodels.FixtureEvents;
import com.livescore.app.model.mymodels.FixtureStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

        Map<Integer, String> homeTypeElapsed = eventList.stream()
                .filter(eventResponse -> eventResponse.getIdTeam().equals(homeId))
                .collect(Collectors.toMap(EventResponse :: getElapsed, EventResponse ::getType));


        Map<Integer, String> awayTypeElapsed = eventList.stream()
                .filter(eventResponse -> eventResponse.getIdTeam().equals(awayId))
                .collect(Collectors.toMap(EventResponse ::getElapsed, EventResponse :: getType));

        Map<Integer, String> homePlayers = eventList.stream()
                .filter(eventResponse -> eventResponse.getIdTeam().equals(homeId))
                .collect(Collectors.toMap(EventResponse :: getElapsed, EventResponse ::getPlayer1Name));


        Map<Integer, String> awayPlayers = eventList.stream()
                .filter(eventResponse -> eventResponse.getIdTeam().equals(awayId))
                .collect(Collectors.toMap(EventResponse ::getElapsed, EventResponse :: getPlayer1Name));



         return new FixtureEvents(homeTypeElapsed,awayTypeElapsed,homePlayers,awayPlayers);

    }
}
