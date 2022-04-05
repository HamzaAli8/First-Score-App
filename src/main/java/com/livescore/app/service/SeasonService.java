package com.livescore.app.service;

import com.livescore.app.model.SeasonData;
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

@Service
public class SeasonService {

    @Value("${api_key}")
    private String apikey;

    @Value("${league_url}")
    private String seasonUrl;


    private String bearer;

    @Autowired
    RestTemplate restTemplate;


    public SeasonData getSeasonByLeagueId(Integer id, String expand) {

        String url = seasonUrl + id + "/seasons" + "?expand={expand}";


        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> request = new HttpEntity<>(headers);
        headers.setBearerAuth(bearer);

        Map<String, String> uriParams = new HashMap<>();
        uriParams.put("expand", expand);

        ResponseEntity<SeasonData> response = restTemplate.exchange(url, HttpMethod.GET, request, SeasonData.class, uriParams);

        return response.getBody();
    }
}
