package com.livescore.app.newsmodel;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserInput {

    private String q;
    private Integer page;
    private Integer size;

}
