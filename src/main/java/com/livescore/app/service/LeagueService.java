package com.livescore.app.service;



import com.livescore.app.model.Data;
import com.livescore.app.model.LeagueResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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



    public Data getLeague(Integer id) {


        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> request = new HttpEntity<>(headers);
        headers.setBearerAuth(bearer);

        ResponseEntity<Data> response = restTemplate.exchange(leagueUrl + id, HttpMethod.GET,request,Data.class);

        return response.getBody();


    }
}
