package com.livescore.app.service;



import com.livescore.app.model.Data;
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
public class LeagueService {

    @Value("${api_key}")
    private String apikey;

    @Value("${league_url}")
    private String leagueUrl;

    @Value("${api_bearer}")
    private String bearer;

    @Autowired
    RestTemplate restTemplate;



    public Data getLeague(Integer id, String expand) {

        String url = leagueUrl + id + "?expand={expand}";


        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> request = new HttpEntity<>(headers);
        headers.setBearerAuth(bearer);

        Map<String, String> uriParams = new HashMap<>();
        uriParams.put("expand", expand);

        ResponseEntity<Data> response = restTemplate.exchange(url, HttpMethod.GET,request,Data.class,uriParams);

        return response.getBody();


    }
}
