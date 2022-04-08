package com.livescore.app.model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PlayerDetailData {

    List<PlayerDetailResponse> data;


}
