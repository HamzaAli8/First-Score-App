package com.livescore.app.service;

import com.livescore.app.newsmodel.NewsResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsService {

    @Autowired
    ApiService apiService;

    public NewsResponses getNewsArticles(){

        return apiService.getNewsArticles();
    }

    public NewsResponses getTeamNewsArticles(String team){

        return apiService.getTeamNewsArticles(team);
    }

    public NewsResponses getLatestArticles(){

        return apiService.getLatestArticles();
    }
}
