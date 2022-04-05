package com.livescore.app.configsecurity;

import com.livescore.app.model.Token;
import com.livescore.app.service.ApiService;
import com.livescore.app.service.AuthService;
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
        return new ApiService(token.getAccessToken());
    }
}
