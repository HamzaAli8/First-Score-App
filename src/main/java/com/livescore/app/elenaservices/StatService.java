package com.livescore.app.elenaservices;

import com.livescore.app.elenamodel.mymodels.FixtureStats;
import com.livescore.app.elenamodel.StatData;
import com.livescore.app.elenamodel.StatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class StatService {

    @Autowired
    ApiService apiService;

    /**
     * This method returns the FixtureStats of a fixture, within the FixtureStats there are two Maps each referencing
     * the homeTeam and the awayTeam. A list of StatResponses have been Mapped into key value pairs for the away and home
     * teams respectively.
     * @param id unique id of the fixture
     * @param homeId unique id of the homeTeam
     * @param awayId unique id of the awayTeam
     * @return
     */
    public FixtureStats getStats(Integer id, Integer homeId, Integer awayId) {

        StatData statData = apiService.getStatsByFixtureId(id);
        List<StatResponse> statList = new ArrayList<>();
        if (statData == null) {

            return null;

        } else {
            statList = statData.getData();
        }

        Map<String, Integer> home = statList.stream()
                .filter(statResponse -> statResponse.getIdTeam().equals(homeId))
                .collect(Collectors.toMap(StatResponse ::getLabel, StatResponse :: getValue));

        Map<String, Integer> away = statList.stream()
                .filter(statResponse -> statResponse.getIdTeam().equals(awayId))
                .collect(Collectors.toMap(StatResponse ::getLabel, StatResponse :: getValue));

        return new FixtureStats(home, away);

    }
}
