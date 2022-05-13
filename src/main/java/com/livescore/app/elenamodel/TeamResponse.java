package com.livescore.app.elenamodel;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TeamResponse {

    private Integer id;
    private String name;
    private String fullName;
    private String country;
    private String founded;
    private String officialPage;
    @JsonProperty("badgeURL")
    private String badgeUrl;

}
