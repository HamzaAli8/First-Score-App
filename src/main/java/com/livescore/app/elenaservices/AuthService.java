package com.livescore.app.elenaservices;

import com.livescore.app.elenamodel.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {


    @Value("${api_key}")
    private String apikey;

    @Autowired
    RestTemplate restTemplate;


    public Token refreshToken() {

        String url = "https://oauth2.elenasport.io/oauth2/token?grant_type=client_credentials";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", apikey);
        headers.set("Content-Type", "application/x-www-form-urlencoded");
        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<Token> response = restTemplate.exchange(url, HttpMethod.POST, request, Token.class);

        return response.getBody();

    }
}
