package com.nriagudubem.search.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class SearchQuery {

    @NotNull
    @NotEmpty
    private String query;
}

