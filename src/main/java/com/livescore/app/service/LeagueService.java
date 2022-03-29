package com.livescore.app.service;



import com.livescore.app.model.LeagueResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class LeagueService {

    @Value("${api_key}")
    private String apikey;

    @Value("${league_url}")
    private String leagueUrl;

    @Autowired
    RestTemplate restTemplate;



    public LeagueResponse getLeague(Integer id) {


        HttpHeaders request = new HttpHeaders();

        request.setBearerAuth();
        restTemplate.getForObject(leagueUrl + "/" + id, LeagueResponse.class);

    }
}
