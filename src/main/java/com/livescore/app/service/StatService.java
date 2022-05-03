package com.livescore.app.service;

import com.livescore.app.model.mymodels.FixtureStats;
import com.livescore.app.model.StatData;
import com.livescore.app.model.StatResponse;
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


//        List<StatResponse> homeList = statList
//                .stream()
//                .filter(s -> s.getIdTeam().equals(homeId)).collect(Collectors.toList());
//
//
//
//        List<StatResponse> awayList = statList
//                .stream()
//                .filter(s -> s.getIdTeam().equals(awayId)).collect(Collectors.toList());





    }
}
