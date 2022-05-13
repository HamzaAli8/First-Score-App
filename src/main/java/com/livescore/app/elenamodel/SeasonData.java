package com.livescore.app.elenamodel;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SeasonData {

    List<SeasonResponse> data;

}
