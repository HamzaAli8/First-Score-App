package com.livescore.app.elenamodel;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LineUpData {

    private List<LineUpResponse> data;
    private Pagination pagination;

}
