package com.livescore.app.elenamodel;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TopScorerData {

    private List<TopScorerResponse> data;

}
