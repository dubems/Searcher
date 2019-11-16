package com.nriagudubem.search.httpClient.email.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class GetEmailResponseDto {

    @NotNull
    @NotEmpty
    private List<PropertiesValue> value;
}
