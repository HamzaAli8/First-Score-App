package com.livescore.app.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StandingData {

    private List<StandingResponse> data;

}
