package com.livescore.app.newsservices;

import com.livescore.app.newsmodel.Articles;
import com.livescore.app.elenaservices.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsService {

    @Autowired
    ApiService apiService;

    /**
     * This method returns a list of random news articles relating to a particular topic which has been passed in as
     * a parameter in the API call.
     * @return List of Articles
     */
    public List<Articles> getNewsArticles(){

        return apiService.getNewsArticles().getArticles();
    }

    /**
     * This method returns a list of specific news articles relating to a particular team which has been passed in as
     * a parameter in the API call.
     * @param team String teamName
     * @return List of Articles
     */
    public  List<Articles> getTeamNewsArticles(String team){

        return apiService.getTeamNewsArticles(team).getArticles();
    }

    /**
     * This method returns a list of the latest news articles, the method uses a hashset to ensure that the list of
     * articles that are returned are not duplicates.
     * @return List of Articles
     */
    public List<Articles> getLatestArticles(){

        List<Articles> news = apiService.getLatestArticles().getArticles();
        HashSet<Object> seen = new HashSet<>();
        return news.stream().filter(articles -> seen.add(articles.getTitle())).collect(Collectors.toList());
    }
}
