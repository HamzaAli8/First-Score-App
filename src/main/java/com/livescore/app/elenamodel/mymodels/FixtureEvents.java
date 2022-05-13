package com.livescore.app.elenamodel.mymodels;

import com.livescore.app.elenamodel.EventResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FixtureEvents {

    private List<EventResponse> homeTypeElapsed;
    private List<EventResponse> awayTypeElapsed;
}
