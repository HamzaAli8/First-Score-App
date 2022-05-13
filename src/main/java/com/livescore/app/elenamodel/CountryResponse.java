package com.livescore.app.elenamodel;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CountryResponse {

    private Integer id;
    private String name;
    private String alpha2code;
    private String alpha3code;
    private String capital;
    private String flag;
    private String region;
    private String subregion;
    private String[] timezones;
    private Expand expand;
}
