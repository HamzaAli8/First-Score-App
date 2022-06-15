package com.livescore.app.elenaservices;

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

    /**
     * This method returns the events from a given game
     * @param id the fixture id of the game
     * @return EventData which has a list of EventResponses contained within
     */

    public EventData getEvents(Integer id) {

        return apiService.getEventByFixtureId(id);
    }

    /**
     * This method returns the stats from a given game, both the home team and away team stats are returned. The data is
     * parsed so that both the home team events and the away teams are returned separately.
     <P>

     * @param id the fixture id which is unique to every game played
     * @param homeId the home team id, which ensures only those events are returned
     * @param awayId the away team id, which ensures only those events are returned
     * @return a list of EventResponses for both the home and away team
     */
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
