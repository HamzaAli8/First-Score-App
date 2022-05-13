package com.livescore.app.newsmodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NewsResponses {

    private String status;
    @JsonProperty("total_pages")
    private Integer totalPages;
    @JsonProperty("page_size")
    private Integer pageSize;
    private List<Articles> articles;
    @JsonProperty("user_input")
    private UserInput userInput;
}
