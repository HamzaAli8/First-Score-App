package com.livescore.app.elenamodel.mymodels;

import com.livescore.app.elenamodel.LineUpResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FixtureLineup {

    List<LineUpResponse> startingHomeLineUp;
    List<LineUpResponse> startingAwayLineUp;
    List<LineUpResponse> homeSubs;
    List<LineUpResponse> awaySubs;

}
