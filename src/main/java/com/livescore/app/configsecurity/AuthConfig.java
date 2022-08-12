package com.livescore.app.configsecurity;

import com.livescore.app.elenamodel.Token;
import com.livescore.app.elenaservices.ApiService;
import com.livescore.app.elenaservices.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthConfig {

    @Autowired
    AuthService authService;

    @Bean
    public ApiService apiService(){
        Token token = authService.refreshToken();
        System.out.println(token);
        return new ApiService(token.getAccessToken());
    }
}
