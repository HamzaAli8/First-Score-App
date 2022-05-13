package com.livescore.app.elenamodel;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StageData {

    private List<StageResponse> data;
}
