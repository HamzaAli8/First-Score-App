package com.livescore.app.newsmodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Articles {

    private String title;
    private String author;
    @JsonProperty("published_date")
    private String publishedDate;
    private String link;
    @JsonProperty("clean_url")
    private String cleanUrl;
    private String excerpt;
    private String summary;
    private String topic;
    private String country;
    private String language;
    private List<String> authors;
    private String media;



}
