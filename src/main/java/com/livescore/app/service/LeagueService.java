package com.livescore.app.service;



import com.livescore.app.model.LeagueData;
import com.livescore.app.model.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
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


    public LeagueData getLeague(Integer id, String expand) {

        String url = leagueUrl + id + "?expand={expand}";


        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> request = new HttpEntity<>(headers);
        headers.setBearerAuth(bearer);

        Map<String, String> uriParams = new HashMap<>();
        uriParams.put("expand", expand);

        ResponseEntity<LeagueData> response = restTemplate.exchange(url, HttpMethod.GET, request, LeagueData.class, uriParams);

        return response.getBody();


    }


    public Token getToken() {

        String url = "https://oauth2.elenasport.io/oauth2/token";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Authorization", apikey);
        HttpEntity<String> request = new HttpEntity<>(headers);

        Map<String, String> requestMap = new HashMap();
        requestMap.put("grant_type", "client_credentials");



        ResponseEntity<Token> response = restTemplate.exchange(url, HttpMethod.POST, request, Token.class,requestMap);

        return response.getBody();

    }


}
