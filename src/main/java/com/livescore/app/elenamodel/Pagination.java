package com.livescore.app.elenamodel;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pagination {

    private Integer page;
    private Integer itemsPerPage;
    private Boolean hasNextPage;
    private Boolean hasPrevPage;

}
