package com.livescore.app.model.mymodels;

import com.livescore.app.model.EventResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FixtureEvents {

    private List<EventResponse> homeTypeElapsed;
    private List<EventResponse> awayTypeElapsed;
}
