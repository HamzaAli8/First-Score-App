package com.livescore.app.service;

import com.livescore.app.model.LeagueData;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class ApiService {

    @Value("${league_url}")
    private String leagueUrl;

    @Autowired
    RestTemplate restTemplate;

    final private String token;

    public ApiService(String token) {
        this.token = token;
    }

    public LeagueData getLeague(Integer id, String expand) {

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

}
