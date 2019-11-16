package com.nriagudubem.search.httpClient.email.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.net.URL;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class PropertiesValue {

    @NotNull
    @NotEmpty
    private String title;

    @NotNull
    private URL url;
}
