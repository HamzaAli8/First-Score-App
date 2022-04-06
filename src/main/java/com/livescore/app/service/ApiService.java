package com.livescore.app.service;

import com.livescore.app.model.LeagueData;
import com.livescore.app.model.SeasonData;
import com.livescore.app.model.StageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class ApiService {

    @Value("${league_url}")
    private String leagueUrl;

    @Value("${league_url}")
    private String seasonUrl;

    @Value("${stage_url}")
    private String stageUrl;

    @Autowired
    RestTemplate restTemplate;

    final private String token;

    public ApiService(String token) {
        this.token = token;
    }

    public LeagueData getLeagueById(Integer id, String expand) {

        String url = leagueUrl + id + "?expand={expand}";



        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> request = new HttpEntity<>(headers);
        headers.setBearerAuth(token);

        Map<String, String> uriParams = new HashMap<>();
        if(expand != null){

            uriParams.put("expand", expand);
        }

        ResponseEntity<LeagueData> response = restTemplate.exchange(url, HttpMethod.GET, request, LeagueData.class, uriParams);

        return response.getBody();

    }

    public SeasonData getSeasonByLeagueId(Integer id, String expand) {

        String url = seasonUrl + id + "/seasons" + "?expand={expand}";


        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> request = new HttpEntity<>(headers);
        headers.setBearerAuth(token);

        Map<String, String> uriParams = new HashMap<>();
        uriParams.put("expand", expand);

        ResponseEntity<SeasonData> response = restTemplate.exchange(url, HttpMethod.GET, request, SeasonData.class, uriParams);

        return response.getBody();
    }



    public StageData getStageBySeasonId(Integer id,String expand) {

        String url = stageUrl + id + "?expand={expand}";


        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> request = new HttpEntity<>(headers);
        headers.setBearerAuth(token);

        Map<String, String> uriParams = new HashMap<>();
        uriParams.put("expand", expand);

        ResponseEntity<StageData> response = restTemplate.exchange(url, HttpMethod.GET,request, StageData.class,uriParams);

        return response.getBody();


    }
}
