package com.livescore.app.elenamodel;

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
