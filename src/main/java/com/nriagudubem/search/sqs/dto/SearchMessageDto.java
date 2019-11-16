package com.nriagudubem.search.sqs.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nriagudubem.search.model.User;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;


@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchMessageDto {
    @NotNull
    @NotEmpty
    private String searchQuery;

    @NotNull
    private User user;

    @NotNull
    Instant now;
}
