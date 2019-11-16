package com.nriagudubem.search.httpClient.email.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
public class GetEmailRequestDto {
    @NotNull
    Boolean autoCorrect;

    @NotNull
    Long pageSize;

    @NotNull
    Boolean safeSearch;

    @NotNull
    Long pageNumber;

    @NotNull
    @NotEmpty
    String query;

}
