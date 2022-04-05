package com.livescore.app.service;



import com.livescore.app.model.LeagueData;
import com.livescore.app.model.Token;
import org.apache.tomcat.util.json.JSONParserTokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.HashMap;
import java.util.Map;

@Service
public class LeagueService {

    @Autowired
    ApiService apiService;

    public LeagueData getLeague(Integer id, String expand){

        return apiService.getLeague(id,expand);

    }







}
