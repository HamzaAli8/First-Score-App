package com.livescore.app.service;

import com.livescore.app.newsmodel.Articles;
import com.livescore.app.newsmodel.NewsResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsService {

    @Autowired
    ApiService apiService;

    public List<Articles> getNewsArticles(){

        return apiService.getNewsArticles().getArticles();
    }

    public  List<Articles> getTeamNewsArticles(String team){

        return apiService.getTeamNewsArticles(team).getArticles();
    }

    public List<Articles> getLatestArticles(){

        List<Articles> news = apiService.getLatestArticles().getArticles();

        HashSet<Object> seen = new HashSet<>();



        return news.stream().filter(articles -> seen.add(articles.getTitle())).collect(Collectors.toList());
    }
}
