package com.livescore.app.elenamodel;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CountryData {

    private List<CountryResponse> data;
}
