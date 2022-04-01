package com.livescore.app.service;

import com.livescore.app.model.StageData;
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
public class StageService {

    @Value("${api_key}")
    private String apikey;

    @Value("${stage_url}")
    private String stageUrl;

    @Value("${api_bearer}")
    private String bearer;

    @Autowired
    RestTemplate restTemplate;

    public StageData getStage(Integer id) {

        String url = stageUrl + id;

//        + "?expand={expand}"


        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> request = new HttpEntity<>(headers);
        headers.setBearerAuth(bearer);

//        Map<String, String> uriParams = new HashMap<>();
//        uriParams.put("expand", expand);

        ResponseEntity<StageData> response = restTemplate.exchange(url, HttpMethod.GET,request, StageData.class);

        return response.getBody();


    }
}
