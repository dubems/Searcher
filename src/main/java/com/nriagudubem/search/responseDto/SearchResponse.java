package com.nriagudubem.search.responseDto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class SearchResponse {

    @NotNull
    private List relatedSearch;

    @NotNull
    private String totalCount;

    @NotNull
    private List value;

}
