package com.livescore.app.model;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LineUpData {

    private List<LineUpResponse> data;

}
