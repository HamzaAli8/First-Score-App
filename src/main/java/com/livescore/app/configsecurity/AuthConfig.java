package com.livescore.app.configsecurity;

import com.livescore.app.elenamodel.Token;
import com.livescore.app.elenaservices.ApiService;
import com.livescore.app.elenaservices.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Timer;
import java.util.TimerTask;

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

    TimerTask task = new TimerTask() {
        @Override
        public void run() {

            apiService();
            Timer timer = new Timer();
            timer.schedule(task, 0L, 1000*60*45);
        }
    };


}
