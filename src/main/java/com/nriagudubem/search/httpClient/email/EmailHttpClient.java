package com.nriagudubem.search.httpClient.email;

import com.nriagudubem.search.httpClient.email.dto.GetEmailResponseDto;
import feign.Logger;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "Email", url = "${search.contextualWeb.host}", configuration = EmailHttpClient.EmailHttpClientConfig.class)
public interface EmailHttpClient {

    @GetMapping(path = "/api/Search/WebSearchAPI", headers = "X-RapidAPI-Key=7aa35b52b1msha729bf0204d90a6p10a82cjsna5a3a0e0ebb8")
//    @Headers( value = {"X-RapidAPI-Key: 7aa35b52b1msha729bf0204d90a6p10a82cjsna5a3a0e0ebb8", "x-rapidapi-host: contextualwebsearch-websearch-v1.p.rapidapi.com"})
    GetEmailResponseDto getEmails(@RequestParam("autoCorrect") boolean isAutoCorrect,
                                  @RequestParam("pageSize") long pageSize,
                                  @RequestParam("safeSearch") boolean safeSearch,
                                  @RequestParam("pageNumber") long pageNumber,
                                  @RequestParam("q") String query);

    @Configuration
    class EmailHttpClientConfig {
        @Bean
        Logger.Level feignLoggerLevel() {
            return Logger.Level.FULL;
        }
    }
}
