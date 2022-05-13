package com.livescore.app.elenamodel;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlayerDetailResponse {

    private Integer id;
    private String name;
    private String [] nationalities;
    private String fullName;
    private String dob;
    private String height;
    private String weight;
    private String foot;
    private String photoURL;

}
