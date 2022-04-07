package com.livescore.app.model;


import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class PlayerData {

    private List<PlayerResponse> data;

}
